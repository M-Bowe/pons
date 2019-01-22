pragma solidity ^0.4.24;

import "./ERC721.sol";

contract Loan is ERC721 {
    
    struct Loan{
        string name; // Name of the loan
        uint balance; // Loan amount
    }
    
    Loan[] public loans; // First Item has Index 0
    address public owner;
    
    constructor() public {
        owner = msg.sender; // The Sender is the Owner; Ethereum Address of the Owner
    }
    
    function createLoan(string _name, address _to) public{
        require(owner == msg.sender); // Only the Owner can create Items
        uint id = loans.length; // Item ID = Length of the Array Items
        loans.push(Loan(_name,5)); // Loan(
        _mint(_to,id); // Assigns the Token to the Ethereum Address that is specified
    }
    
}
