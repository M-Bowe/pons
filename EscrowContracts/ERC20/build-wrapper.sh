rm -R generated
mkdir generated
solc EscrowERC20.sol --bin --abi --optimize -o generated/ --overwrite
web3j solidity generate -b generated/EscrowERC20.bin -a generated/EscrowERC20.abi -o ../../Bridge/src/main/java -p com.pons.bridge.contracts
echo "Created Wrapper Class"
