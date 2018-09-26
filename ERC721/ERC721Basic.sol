pragma solidity ^0.4.0;
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
    
    
    // we map each token index or id to an owner.
    mapping (uint256 => address) internal tokenOwner
    // Mapping from token ID to index of the owner tokens list 
    mapping(uint256 => uint256) internal ownedTokensIndex; 
    // Mapping from token id to position in the allTokens array 
    mapping(uint256 => uint256) internal allTokensIndex;
    
    // keep check of total owm token
    mapping (address => uint256) internal ownedTokensCount
    
}