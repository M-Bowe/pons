pragma solidity ^0.4.17;

import './ERC721Token.sol';
import './Ownable.sol';

contract PonsToken is ERC721Token, Ownable {
  string public constant name = "PonsToken";
  string public constant symbol = "PONS";
}