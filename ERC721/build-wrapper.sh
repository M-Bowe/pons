rm -R generated
mkdir generated
solc Loan.sol --bin --abi --optimize -o generated/ --overwrite
web3j solidity generate -b generated/Loan.bin -a generated/Loan.abi -o ../Bridge/src/main/java -p com.pons.bridge.contracts
echo "Created Wrapper Class"
