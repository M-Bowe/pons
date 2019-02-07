pragma solidity ^0.4.24;

import "./ERC721.sol";

contract Loan is ERC721 {
    
    struct loan{
        string name; // Name of the loan
        uint balance; // Loan amount
    }
    
    loan[] public loans; // First Item has Index 0
    address public owner;
    
    constructor() public {
        owner = msg.sender; // The Sender is the Owner; Ethereum Address of the Owner
    }
    
    function createLoan(string _name, address _to, uint _balance) public{
        require(owner == msg.sender); // Only the Owner can create Items
        uint256 id = loans.length; // Item ID = Length of the Array Items
        loans.push(loan(_name,_balance)); 
        _mint(_to,id); // Assigns the Token to the Ethereum Address that is specified

    }
    
    function transfer_token(uint256 _id, address _to) public{
      // need require(isValidToken(_id)
      // need require(getApproved(_tokenId) == address(this))

      transferFrom(ownerOf(_id),_to,_id);

    }
    
}
