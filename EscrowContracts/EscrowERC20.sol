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

    function freeFromEscrow(string _passcode) public returns (bool) {
        if(stringToBytes32(passcode) == stringToBytes32(_passcode)){
            selfdestruct(toERC20);
            return true;
        }

        else {
            selfdestruct(fromERC20);
            return false;
        }

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
