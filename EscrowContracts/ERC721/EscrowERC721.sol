pragma solidity ^0.4.25;

import "ERC721/Loan.sol";

contract EscrowERC721{

    address private owner;
    address private fromERC721;
    address private toERC721;
    string private passcode; // This is a SHA256 hashed passcode
    uint256 private erc721ID;

    constructor() public {
        owner = msg.sender;
    }

    function() public payable{}

    function setParams(address _from, address _to, string _passcode, uint256 _id) public returns (bool){
        if(msg.sender == owner){
            fromERC721 = _from;
            toERC721 = _to;
            passcode = _passcode;
            erc721ID = _id;
            return true;
        }
        else return false;
    }

    function freeFromEscrow(address _existingContract, string _pass) public returns (bool){
  	Loan my_loan = Loan(_existingContract);
        if (stringToBytes32(_pass) == stringToBytes32(passcode)){
          require(my_loan.transfer_token(erc721ID,toERC721), "The remote call has failed");
          return true;
        }
        return false;
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
	
	function testConnection() public returns (bool){
		return true;
    }

}
