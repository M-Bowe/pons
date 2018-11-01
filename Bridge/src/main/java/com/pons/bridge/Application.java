package com.pons.bridge;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.sql.rowset.WebRowSet;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import com.pons.contracts.MonetaryToken;
import com.pons.contracts.PonsERC721;

/**
 * A simple web3j application that demonstrates a number of core features of web3j:
 *
 * <ol>
 *     <li>Connecting to a node on the Ethereum network</li>
 *     <li>Loading an Ethereum wallet file</li>
 *     <li>Sending Ether from one address to another</li>
 *     <li>Deploying a smart contract to the network</li>
 *     <li>Reading a value from the deployed smart contract</li>
 *     <li>Updating a value in the deployed smart contract</li>
 *     <li>Viewing an event logged by the smart contract</li>
 * </ol>
 *
 * <p>To run this demo, you will need to provide:
 *
 * <ol>
 *     <li>Ethereum client (or node) endpoint. The simplest thing to do is
 *     <a href="https://infura.io/register.html">request a free access token from Infura</a></li>
 *     <li>A wallet file. This can be generated using the web3j
 *     <a href="https://docs.web3j.io/command_line.html">command line tools</a></li>
 *     <li>Some Ether. This can be requested from the
 *     <a href="https://www.rinkeby.io/#faucet">Rinkeby Faucet</a></li>
 * </ol>
 *
 * <p>For further background information, refer to the project README.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        new Application().run();
    }

    private void run() throws Exception {
        // We start by creating a new web3j instance to connect to remote nodes on the network.
        // Note: if using web3j Android, use Web3jFactory.build(...
        Web3j web3j = Web3j.build(new HttpService("http://localhost:22000"));  // FIXME: Enter your Infura token here;
        System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        
        // We then need to load our Ethereum wallet file
        // FIXME: Generate a new wallet file using the web3j command line tools https://docs.web3j.io/command_line.html
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "",
                        "/home/quorum-examples/examples/7nodes/keys/key1");
        System.out.println("Credentials loaded");

        // FIXME: Request some Ether for the Rinkeby test network at https://www.rinkeby.io/#faucet
        //System.out.println("Sending 1 Wei ("
        //        + Convert.fromWei("1", Convert.Unit.ETHER).toPlainString() + " Ether)");
        //TransactionReceipt transferReceipt = Transfer.sendFunds(
        //        web3j, credentials,
        //        "0xed9d02e382b34818e88b88a309c7fe71e65f419d",  // you can put any address here
        //        BigDecimal.ONE, Convert.Unit.WEI)  // 1 wei = 10^-18 Ether
        //        .send();
        //System.out.println("Transaction complete, view it at https://rinkeby.etherscan.io/tx/"
        //        + transferReceipt.getTransactionHash());

        // Now lets deploy a smart contract
        System.out.println("Block Number: " + web3j.ethBlockNumber().send().getResult());
        System.out.println("Accounts on nodes:");
        for(String account: web3j.ethAccounts().send().getAccounts()){
        	System.out.println(account);
        }
        
        System.out.println();
        System.out.println("Credentials:");
        String accountStr = credentials.getAddress();
        String accountBalance = web3j.ethGetBalance(accountStr, DefaultBlockParameterName.LATEST).send().getBalance().toString();
        System.out.println("Account: " + accountStr);
        System.out.println("Balance: "+ accountBalance);
        
        System.out.println();
        System.out.println("Deploying smart contract ERC20");
        ContractGasProvider contractGasProvider = new DefaultGasProvider();
        System.out.println("Gas Price: " + contractGasProvider.getGasPrice(Contract.FUNC_DEPLOY));
        System.out.println("Gas Limit: " + contractGasProvider.getGasLimit(Contract.FUNC_DEPLOY));
        MonetaryToken erc20contract = MonetaryToken.deploy(
                web3j,
                credentials,
                new BigInteger("0"),
                MonetaryToken.GAS_LIMIT
                ).send();
        String contractAddress = erc20contract.getContractAddress();
        System.out.println("ERC20 Smart contract deployed to address " + contractAddress);
        System.out.println("ERC20 Total Supply: " + erc20contract.totalSupply().send());
        
        System.out.println();
        System.out.println("Deploying smart contract ERC721");
        PonsERC721 erc721Contract = PonsERC721.deploy(
                web3j,
                credentials,
                new BigInteger("0"),
                MonetaryToken.GAS_LIMIT
                ).send();
        contractAddress = erc721Contract.getContractAddress();
        System.out.println("ERC721 Smart contract deployed to address " + contractAddress);
        System.out.println("ERC721 Total Supply: " + erc721Contract.totalSupply().send());

        // Lets modify the value in our smart contract
        //TransactionReceipt transactionReceipt = contract.transfer(, _value)("Well hello again").send();

        //System.out.println("New value stored in remote smart contract: " + contract.greet().send());

        // Events enable us to log specific events happening during the execution of our smart
        // contract to the blockchain. Index events cannot be logged in their entirety.
        // For Strings and arrays, the hash of values is provided, not the original value.
        // For further information, refer to https://docs.web3j.io/filters.html#filters-and-events
//        for (Greeter.ModifiedEventResponse event : contract.getModifiedEvents(transactionReceipt)) {
//        	System.out.println("Modify event fired, previous value: " + event.oldGreeting
//                    + ", new value: " + event.newGreeting);
//        	System.out.println("Indexed event previous value: " + Numeric.toHexString(event.oldGreetingIdx)
//                    + ", new value: " + Numeric.toHexString(event.newGreetingIdx));
//        }
    }
}
