rm -R generated
mkdir generated
solc EscrowERC20.sol --bin --abi --optimize -o generated/ --overwrite
web3j solidity generate generated/EscrowERC20.bin generated/EscrowERC20.abi -o ../Bridge/src/main/java -p com.pons.bridge.contracts
echo "Created Wrapper Class"
