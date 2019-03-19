rm -R generated
mkdir generated
solc ERC20-Token.sol --bin --abi --optimize -o generated/ --overwrite
web3j solidity generate -b generated/MonetaryToken.bin -a generated/MonetaryToken.abi -o ../Bridge/src/main/java -p com.pons.bridge.contracts
echo "Created Wrapper Class"
