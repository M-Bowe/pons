rm -R generated
mkdir generated
solc ERC721.sol --bin --abi --optimize -o generated/ --overwrite
web3j solidity generate generated/PonsERC721.bin generated/PonsERC721.abi -o ../Bridge/src/main/java -p com.pons.contracts
echo "Created Wrapper Class"
