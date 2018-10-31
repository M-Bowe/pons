rm -R generated
mkdir generated
solc Remix/ERC721Token.sol --bin --abi --optimize -o generated/ --overwrite
#web3j solidity generate generated/MonetaryToken.bin generated/MonetaryToken.abi -o ../Bridge/src/main/java -p com.pons.Contracts
echo "Created Wrapper Class"
