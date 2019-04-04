pragma solidity ^0.4.25;

import "./IERC721Receiver.sol";

contract EscrowERC721 is IERC721Receiver {
    
    address private owner;
    address private fromERC721;
    address private toERC721;
    string private passcode; // This is a SHA256 hashed passcode
    uint256 private erc721ID;
    
    constructor() public {
        owner = msg.sender;
    }
    
    function() public payable{}
    
    function setParams(address _from, address _to, string _passcode, uint256 _id) public returns (bool success){
        if(msg.sender == owner){
            fromERC721 = _from;
            toERC721 = _to;
            passcode = _passcode;
            erc721ID = _id;
            return true;
        }
        else return false;
    }
	
	function getFrom() constant public returns(address from){
		return fromERC721;
	}
	
	function getTo() constant public returns(address to){
		return toERC721;
	}
	
	function getTokenId() constant public returns(uint256 id){
		return erc721ID;
	}
    
    function createLoan(address _existingContract, string _name, uint _balance) public returns (bool success) {
        require(_existingContract.call(bytes4(keccak256("createLoan(string,address,uint256)")),_name,toERC721,_balance));
        return true;
    }

    function freeFromEscrow(address _existingContract, string _pass) public returns (bool success){
        if (stringToBytes32(_pass) == stringToBytes32(passcode)){
            require(_existingContract.call(bytes4(keccak256("transfer_token(uint256,address)")),erc721ID,toERC721));
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

    function onERC721Received(address _operator, address _from, uint256 _tokenId, bytes _data) external returns(bytes4){
        return bytes4(keccak256("onERC721Received(address,address,uint256,bytes)"));
    } 
}
