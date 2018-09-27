pragma solidity ^0.4.0;

/// A Token contract with basic Ethereum functionality
contract Token {

    /// @return total amount of tokens
    function totalSupply() constant returns (uint256 supply) {}

    /// @param _owner The address from which the balance will be retrieved
    /// @return The balance
    function balanceOf(address _owner) constant returns (uint256 balance) {}

    /// @notice send `_value` token to `_to` from `msg.sender`
    /// @param _to The address of the recipient
    /// @param _value The amount of token to be transferred
    /// @return Whether the transfer was successful or not
    function transfer(address _to, uint256 _value) returns (bool success) {}

    /// @notice send `_value` token to `_to` from `_from` on the condition it is approved by `_from`
    /// @param _from The address of the sender
    /// @param _to The address of the recipient
    /// @param _value The amount of token to be transferred
    /// @return Whether the transfer was successful or not
    function transferFrom(address _from, address _to, uint256 _value) returns (bool success) {}

    /// @notice `msg.sender` approves `_addr` to spend `_value` tokens
    /// @param _spender The address of the account able to transfer the tokens
    /// @param _value The amount of wei to be approved for transfer
    /// @return Whether the approval was successful or not
    function approve(address _spender, uint256 _value) returns (bool success) {}

    /// @param _owner The address of the account owning tokens
    /// @param _spender The address of the account able to transfer the tokens
    /// @return Amount of remaining tokens allowed to spent
    function allowance(address _owner, address _spender) constant returns (uint256 remaining) {}

    event Transfer(address indexed _from, address indexed _to, uint256 _value);
    event Approval(address indexed _owner, address indexed _spender, uint256 _value);

}



contract ERC721Basic {
    
    
    
    public ERC721Basic(){
        
    }
    
    
    function addTokenTo(address _to, uint256 _tokenId) internal {
        require(tokenOwner[_tokenId] == address(0));
        tokenOwner[_tokenId] = _to;
        ownedTokensCount[_to] = ownedTokensCount[_to].add(1);
    }
    
    function _mint(address _to, uint256 _tokenId) internal {
        require(_to != address(0));
        addTokenTo(_to, _tokenId);
        Transfer(address(0), _to, _tokenId);
     }
     
     function exists(uint256 _tokenId) public view returns (bool) {
        address owner = tokenOwner[_tokenId];
        return owner != address(0);
     }
     
    
    // this one will keep track of every running ERC 721 token in the contract
    uint256[] internal allTokens
    
    // individual address has an array of token indexes or ids that is mapped to their address as ownership
    // in case an address owner more than 1 token ERC721 (each ERC 721 token is unique like token 5 is not same as token 6)   
    mapping (address => uint256[]) internal ownedTokens
    
    // we map each token index or id to an owner.
    // if we want to check who is the onwer of a token. avoid us to iterate through the townedTokens every time we perform transaction
    mapping (uint256 => address) internal tokenOwner
    
    // Mapping from token ID to index of the tokens onwer list 
    mapping(uint256 => uint256) internal ownedTokensIndex; 
    
    // Mapping from token id to position in the allTokens array 
    mapping(uint256 => uint256) internal allTokensIndex;
    
    // keep check of total owm token
    mapping (address => uint256) internal ownedTokensCount
    
    // Optional mapping for token URIs . THis is for token to hold metadata
    mapping(uint256 => string) internal tokenURIs;
    
}