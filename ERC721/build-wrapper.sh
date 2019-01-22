rm -R generated
mkdir generated
solc Loan.sol --bin --abi --optimize -o generated/ --overwrite
web3j solidity generate generated/Loan.bin generated/Loan.abi -o ../Bridge/src/main/java -p com.pons.bridge.contracts
echo "Created Wrapper Class"
