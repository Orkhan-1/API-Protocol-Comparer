import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.tech.with.orkhan.demo.Book;
import org.tech.with.orkhan.demo.BookServiceGrpc;

public class GRPCClient {

 public static void main(String[] args){
     ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

     BookServiceGrpc.BookServiceBlockingStub stub =  BookServiceGrpc.newBlockingStub(channel);

     Book.BookRequest request = Book.BookRequest.newBuilder().setBookId(10).build();

     Book.BookResponse response = stub.getBook(request);

     System.out.println(response);
 }

}
