package com.pons.bridge.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class MonetaryToken extends Contract {
    private static final String BINARY = "60c0604052600460808190527f48312e300000000000000000000000000000000000000000000000000000000060a090815262000040916007919062000153565b503480156200004e57600080fd5b50620f4240600281905533600090815260208181526040808320939093556003919091558151808301909252600e8083527f4d6f6e657461727920546f6b656e00000000000000000000000000000000000092909101918252620000b59160049162000153565b506005805460ff191660121790556040805180820190915260038082527f4d4f4e00000000000000000000000000000000000000000000000000000000006020909201918252620001099160069162000153565b5060088054600160a060020a031916331790556040805160208101918290526000908190526200013c9160099162000153565b506008805460a060020a60ff0219169055620001f8565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200019657805160ff1916838001178555620001c6565b82800160010185558215620001c6579182015b82811115620001c6578251825591602001919060010190620001a9565b50620001d4929150620001d8565b5090565b620001f591905b80821115620001d45760008155600101620001df565b90565b610f9d80620002086000396000f3006080604052600436106100f85763ffffffff60e060020a60003504166306fdde03811461010a578063095ea7b31461019457806318160ddd146101cc578063224b610b146101f357806323b872dd14610208578063290bb45314610232578063313ce5671461028d57806352196812146102b857806354fd4d50146102cd578063599e74af146102e257806370a082311461033b5780639358928b1461035c57806395d89b4114610371578063a63c500f14610386578063a9059cbb1461039b578063bed34bba146103bf578063cae9ca5114610456578063ce0e19ba146104bf578063dd62ed3e14610518578063dd83fdf61461053f575b34801561010457600080fd5b50600080fd5b34801561011657600080fd5b5061011f610598565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610159578181015183820152602001610141565b50505050905090810190601f1680156101865780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101a057600080fd5b506101b8600160a060020a0360043516602435610626565b604080519115158252519081900360200190f35b3480156101d857600080fd5b506101e161068d565b60408051918252519081900360200190f35b3480156101ff57600080fd5b5061011f610693565b34801561021457600080fd5b506101b8600160a060020a03600435811690602435166044356106ee565b34801561023e57600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261028b9436949293602493928401919081908401838280828437509497506107d99650505050505050565b005b34801561029957600080fd5b506102a26107f0565b6040805160ff9092168252519081900360200190f35b3480156102c457600080fd5b506101e16107f9565b3480156102d957600080fd5b5061011f610818565b3480156102ee57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101b89436949293602493928401919081908401838280828437509497506108739650505050505050565b34801561034757600080fd5b506101e1600160a060020a03600435166109de565b34801561036857600080fd5b506101e16109f9565b34801561037d57600080fd5b5061011f6109ff565b34801561039257600080fd5b506101b8610a5a565b3480156103a757600080fd5b506101b8600160a060020a0360043516602435610a7b565b3480156103cb57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101b894369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a999881019791965091820194509250829150840183828082843750949750610b129650505050505050565b34801561046257600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526101b8948235600160a060020a0316946024803595369594606494920191908190840183828082843750949750610bd49650505050505050565b3480156104cb57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101e1943694929360249392840191908190840183828082843750949750610d6f9650505050505050565b34801561052457600080fd5b506101e1600160a060020a0360043581169060243516610db6565b34801561054b57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101b8943694929360249392840191908190840183828082843750949750610de19650505050505050565b6004805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561061e5780601f106105f35761010080835404028352916020019161061e565b820191906000526020600020905b81548152906001019060200180831161060157829003601f168201915b505050505081565b336000818152600160209081526040808320600160a060020a038716808552908352818420869055815186815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a35060015b92915050565b60025481565b6009805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561061e5780601f106105f35761010080835404028352916020019161061e565b600160a060020a03831660009081526020819052604081205482118015906107395750600160a060020a03841660009081526001602090815260408083203384529091529020548211155b80156107455750600082115b156107ce57600160a060020a0380841660008181526020818152604080832080548801905593881680835284832080548890039055600182528483203384528252918490208054879003905583518681529351929391927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a35060016107d2565b5060005b9392505050565b80516107ec906009906020840190610ed9565b5050565b60055460ff1681565b600854600160a060020a03166000908152600a60205260409020545b90565b6007805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561061e5780601f106105f35761010080835404028352916020019161061e565b6009805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815260009361090d93919290918301828280156109025780601f106108d757610100808354040283529160200191610902565b820191906000526020600020905b8154815290600101906020018083116108e557829003601f168201915b505050505083610b12565b1561094f57506008805474ff000000000000000000000000000000000000000019167401000000000000000000000000000000000000000017905560016109d9565b60098054604080516020601f600260001961010060018816150201909516949094049384018190048102820181019092528281526109b193909290918301828280156109025780601f106108d757610100808354040283529160200191610902565b15156109d957506008805474ff00000000000000000000000000000000000000001916905560005b919050565b600160a060020a031660009081526020819052604090205490565b60035481565b6006805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561061e5780601f106105f35761010080835404028352916020019161061e565b60085474010000000000000000000000000000000000000000900460ff1681565b336000908152602081905260408120548211801590610a9a5750600082115b15610b0a573360008181526020818152604080832080548790039055600160a060020a03871680845292819020805487019055805186815290519293927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929181900390910190a3506001610687565b506000610687565b6000816040518082805190602001908083835b60208310610b445780518252601f199092019160209182019101610b25565b51815160209384036101000a6000190180199092169116179052604051919093018190038120885190955088945090928392508401908083835b60208310610b9d5780518252601f199092019160209182019101610b7e565b5181516020939093036101000a60001901801990911692169190911790526040519201829003909120939093149695505050505050565b336000818152600160209081526040808320600160a060020a038816808552908352818420879055815187815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a383600160a060020a031660405180807f72656365697665417070726f76616c28616464726573732c75696e743235362c81526020017f616464726573732c627974657329000000000000000000000000000000000000815250602e019050604051809103902060e060020a9004338530866040518563ffffffff1660e060020a0281526004018085600160a060020a0316600160a060020a0316815260200184815260200183600160a060020a0316600160a060020a03168152602001828051906020019080838360005b83811015610d14578181015183820152602001610cfc565b50505050905090810190601f168015610d415780820380516001836020036101000a031916815260200191505b509450505050506000604051808303816000875af1925050501515610d6557600080fd5b5060019392505050565b600854600160a060020a03166000908152600a60209081526040822080546001810180835591845282842085519293610daf939190920191860190610ed9565b5092915050565b600160a060020a03918216600090815260016020908152604080832093909416825291909152205490565b6000805b610ded6107f9565b811015610ece57600854600160a060020a03166000908152600a602052604090208054610eb8919083908110610e1f57fe5b600091825260209182902001805460408051601f6002600019610100600187161502019094169390930492830185900485028101850190915281815292830182828015610ead5780601f10610e8257610100808354040283529160200191610ead565b820191906000526020600020905b815481529060010190602001808311610e9057829003601f168201915b505050505084610b12565b15610ec65760009150610ed3565b600101610de5565b600191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610f1a57805160ff1916838001178555610f47565b82800160010185558215610f47579182015b82811115610f47578251825591602001919060010190610f2c565b50610f53929150610f57565b5090565b61081591905b80821115610f535760008155600101610f5d5600a165627a7a72305820c9e746d377492bfb19f30a8ffbd9e32318ed08f46365d37e1f80cd2fe2f863b20029";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_PASSWORD = "password";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_SETPASSWORD = "setPassword";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_GETLOANCOUNT = "getLoanCount";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC_LOCKCONTRACT = "lockContract";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_CIRCULATINGSUPPLY = "circulatingSupply";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_IS_LOCKED = "is_locked";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_COMPARESTRINGS = "compareStrings";

    public static final String FUNC_APPROVEANDCALL = "approveAndCall";

    public static final String FUNC_APPENDSTRING = "appendString";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_VALIDLOANADDRESS = "validLoanAddress";

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected MonetaryToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MonetaryToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MonetaryToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MonetaryToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> password() {
        final Function function = new Function(FUNC_PASSWORD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setPassword(String pass) {
        final Function function = new Function(
                FUNC_SETPASSWORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(pass)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getLoanCount() {
        final Function function = new Function(FUNC_GETLOANCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> lockContract(String local_pass) {
        final Function function = new Function(
                FUNC_LOCKCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(local_pass)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> circulatingSupply() {
        final Function function = new Function(FUNC_CIRCULATINGSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> is_locked() {
        final Function function = new Function(FUNC_IS_LOCKED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> compareStrings(String a, String b) {
        final Function function = new Function(FUNC_COMPARESTRINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(a), 
                new org.web3j.abi.datatypes.Utf8String(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> approveAndCall(String _spender, BigInteger _value, byte[] _extraData) {
        final Function function = new Function(
                FUNC_APPROVEANDCALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.DynamicBytes(_extraData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> appendString(String appendThis) {
        final Function function = new Function(
                FUNC_APPENDSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(appendThis)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner), 
                new org.web3j.abi.datatypes.Address(_spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> validLoanAddress(String checkVal) {
        final Function function = new Function(FUNC_VALIDLOANADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(checkVal)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public static RemoteCall<MonetaryToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MonetaryToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<MonetaryToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MonetaryToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MonetaryToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MonetaryToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MonetaryToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MonetaryToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventObservable(filter);
    }

    @Deprecated
    public static MonetaryToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MonetaryToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MonetaryToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MonetaryToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MonetaryToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MonetaryToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MonetaryToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MonetaryToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class TransferEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _value;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String _owner;

        public String _spender;

        public BigInteger _value;
    }
}
