pragma solidity ^0.4.24;

import "./ERC721.sol";

contract Loan is ERC721 {
    
    event MyEvent(
        string description
    );
  
    struct loan{
        string name; // Name of the loan
        uint balance; // Loan amount
    }
    
    loan[] public loans; // First Item has Index 0
    address public owner;
    
    constructor() public {
        owner = msg.sender; // The Sender is the Owner; Ethereum Address of the Owner
    }
    
    function createLoan(string _name, address _to, uint _balance) public {
        // require(owner == msg.sender); // Only the Owner can create Items
        uint256 id = loans.length; // Item ID = Length of the Array Items
        loans.push(loan(_name,_balance)); 
        _mint(_to,id); // Assigns the Token to the Ethereum Address that is specified

        emit MyEvent("createLoan() executed");
    
    }

    function approve_token(uint256 _id, address _to) public {
      emit Approval(ownerOf(_id), _to, _id);
    }
    
    function transfer_token(uint256 _id, address _to) public{

        safeTransferFrom(ownerOf(_id),_to,_id);
    
        emit MyEvent("transfer_token() executed");

    }
    
}
