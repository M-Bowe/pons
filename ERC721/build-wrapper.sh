rm -R generated
mkdir generated
solc ERC721.sol --bin --abi --optimize -o generated/ --overwrite
#web3j solidity generate generated/MonetaryToken.bin generated/MonetaryToken.abi -o ../Bridge/src/main/java -p com.pons.Contracts
echo "Created Wrapper Class"
