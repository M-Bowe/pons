rm -R generated
mkdir generated
solc EscrowERC721.sol --bin --abi --optimize -o generated/ --overwrite
web3j solidity generate generated/EscrowERC721.bin generated/EscrowERC721.abi -o ../../Bridge/src/main/java -p com.pons.bridge.contracts
echo "Created Wrapper Class"
