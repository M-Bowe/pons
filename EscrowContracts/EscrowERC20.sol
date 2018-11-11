pragma solidity ^0.4.25;


contract EscrowERC20 {

    bool public canFree;
    address private owner;
    address private fromERC20;
    address private toERC20;
    string private passcode; // This is a SHA256 hashed passcode
    uint256 private erc20Amount;

    constructor() public {
        canFree = false;
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

    function freeFromEscrow(address _to) public {
        if(msg.sender == owner){
            if(canFree) selfdestruct(_to);
            else selfdestruct(msg.sender);
        }
    }

    function switchBool() public returns (bool){
        if(msg.sender == owner){
            canFree = !canFree;
            return canFree;
        }
        else return false;
    }

}
