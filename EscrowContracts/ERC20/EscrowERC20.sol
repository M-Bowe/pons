pragma solidity ^0.4.25;


contract EscrowERC20 {

    address private owner;
    address private fromERC20;
    address private toERC20;
    string private passcode; // This is a SHA256 hashed passcode
    uint256 private erc20Amount;

    constructor() public {
        owner = msg.sender;
    }

    function() public payable{}

    function setParams(address _from, address _to, string _passcode, uint256 quantity) public returns (bool){
        if(msg.sender == owner){
            fromERC20 = _from;
            toERC20 = _to;
            passcode = _passcode;
            erc20Amount = quantity;
            return true;
        }
        else return false;
    }
	
	function getFrom() constant public returns(address from){
		return fromERC20;
	}
	
	function getTo() constant public returns(address to){
		return toERC20;
	}
	
	function getAmount() constant public returns(uint256){
		return erc20Amount;
	}

    function freeFromEscrow(address _existingContract, string _pass) public returns (bool){
        if (stringToBytes32(_pass) == stringToBytes32(passcode)){
          require(_existingContract.call(bytes4(keccak256("transfer(address,uint256)")),toERC20,erc20Amount));
          return true;
        }
        return false;
    }

    function testSD(address  _ad) public {

        selfdestruct(_ad);
    }


   
    function stringToBytes32(string memory source) internal pure returns (bytes32 result) {
        bytes memory tempEmptyStringTest = bytes(source);
        if (tempEmptyStringTest.length == 0) {
            return 0x0;
        }

        assembly {
            result := mload(add(source, 32))
        }
    }

}
