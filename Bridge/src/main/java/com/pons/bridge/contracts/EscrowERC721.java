package com.pons.bridge.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.0.1.
 */
public class EscrowERC721 extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a0319163317905561070b806100326000396000f3006080604052600436106100695763ffffffff60e060020a600035041663010a38f5811461006b5780630ad2571f14610092578063150b7a021461010d5780636b83420c1461017b57806371492685146101e4578063798fd17814610215578063886ed6b41461022a575b005b34801561007757600080fd5b5061008061029b565b60408051918252519081900360200190f35b34801561009e57600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100f9958335600160a060020a03169536956044949193909101919081908401838280828437509497506102a29650505050505050565b604080519115158252519081900360200190f35b34801561011957600080fd5b50610146600160a060020a03600480358216916024803590911691604435916064359081019101356103eb565b604080517fffffffff000000000000000000000000000000000000000000000000000000009092168252519081900360200190f35b34801561018757600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100f9958335600160a060020a0316953695604494919390910191908190840183828082843750949750509335945061044c9350505050565b3480156101f057600080fd5b506101f9610587565b60408051600160a060020a039092168252519081900360200190f35b34801561022157600080fd5b506101f9610596565b34801561023657600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100f9948235600160a060020a039081169560248035909216953695946064949293019190819084018382808284375094975050933594506105a59350505050565b6004545b90565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815260009361033b93919290918301828280156103315780601f1061030657610100808354040283529160200191610331565b820191906000526020600020905b81548152906001019060200180831161031457829003601f168201915b5050505050610623565b61034483610623565b14156103e157604080517f7472616e736665725f746f6b656e2875696e743235362c6164647265737329008152815190819003601f0181206004805460025463ffffffff60e060020a94859004908116909402855291840152600160a060020a0390811660248401529251928616929091604480820192600092909190829003018183875af19250505015156103d957600080fd5b5060016103e5565b5060005b92915050565b604080517f6f6e455243373231526563656976656428616464726573732c6164647265737381527f2c75696e743235362c62797465732900000000000000000000000000000000006020820152905190819003602f01902095945050505050565b600083600160a060020a031660405180807f6372656174654c6f616e28737472696e672c616464726573732c75696e74323581526020017f36290000000000000000000000000000000000000000000000000000000000008152506022019050604051809103902060e060020a900484600260009054906101000a9004600160a060020a0316856040518463ffffffff1660e060020a02815260040180848051906020019080838360005b8381101561050f5781810151838201526020016104f7565b50505050905090810190601f16801561053c5780820380516001836020036101000a031916815260200191505b5083600160a060020a0316600160a060020a0316815260200182815260200193505050506000604051808303816000875af192505050151561057d57600080fd5b5060019392505050565b600254600160a060020a031690565b600154600160a060020a031690565b60008054600160a060020a03163314156106175760018054600160a060020a0380881673ffffffffffffffffffffffffffffffffffffffff199283161790925560028054928716929091169190911790558251610609906003906020860190610647565b50506004819055600161061b565b5060005b949350505050565b8051600090829015156106395760009150610641565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061068857805160ff19168380011785556106b5565b828001600101855582156106b5579182015b828111156106b557825182559160200191906001019061069a565b506106c19291506106c5565b5090565b61029f91905b808211156106c157600081556001016106cb5600a165627a7a7230582040ac9e778cac27620c6f1e0b498a1021a68f4e1f9e248147fad68b262362f0ba0029";

    public static final String FUNC_GETTOKENID = "getTokenId";

    public static final String FUNC_FREEFROMESCROW = "freeFromEscrow";

    public static final String FUNC_ONERC721RECEIVED = "onERC721Received";

    public static final String FUNC_CREATELOAN = "createLoan";

    public static final String FUNC_GETTO = "getTo";

    public static final String FUNC_GETFROM = "getFrom";

    public static final String FUNC_SETPARAMS = "setParams";

    @Deprecated
    protected EscrowERC721(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EscrowERC721(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EscrowERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EscrowERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getTokenId() {
        final Function function = new Function(FUNC_GETTOKENID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> freeFromEscrow(String _existingContract, String _pass) {
        final Function function = new Function(
                FUNC_FREEFROMESCROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_existingContract), 
                new org.web3j.abi.datatypes.Utf8String(_pass)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> onERC721Received(String _operator, String _from, BigInteger _tokenId, byte[] _data) {
        final Function function = new Function(
                FUNC_ONERC721RECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_operator), 
                new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokenId), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createLoan(String _existingContract, String _name, BigInteger _balance) {
        final Function function = new Function(
                FUNC_CREATELOAN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_existingContract), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_balance)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getTo() {
        final Function function = new Function(FUNC_GETTO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getFrom() {
        final Function function = new Function(FUNC_GETFROM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setParams(String _from, String _to, String _passcode, BigInteger _id) {
        final Function function = new Function(
                FUNC_SETPARAMS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.Utf8String(_passcode), 
                new org.web3j.abi.datatypes.generated.Uint256(_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static EscrowERC721 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EscrowERC721(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EscrowERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EscrowERC721(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EscrowERC721 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EscrowERC721(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EscrowERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EscrowERC721(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EscrowERC721> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EscrowERC721.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<EscrowERC721> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EscrowERC721.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EscrowERC721> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EscrowERC721.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EscrowERC721> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EscrowERC721.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
