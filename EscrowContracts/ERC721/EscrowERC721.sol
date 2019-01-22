pragma solidity ^0.4.25;


contract EscrowERC721 {

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

    function testTransfer(address _existingContract) public returns (bool){
        require(_existingContract.call(bytes4(keccak256("transferFrom(address,address,uint256)")),fromERC721,toERC721,erc721ID));
        return true;
    }

    function testSD(address  _ad) public {

        selfdestruct(_ad);
    }

    function freeFromEscrow(string _passcode) public returns (bool) {
        if(stringToBytes32(passcode) == stringToBytes32(_passcode)){
            selfdestruct(toERC721);
            return true;
        }
        else {
            selfdestruct(fromERC721);
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
