package section_14._08_nio.filechannelcopy;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelCopy {

    public static void copyCalledFromTheDestination() {
        try (RandomAccessFile ra = new RandomAccessFile("data.txt", "rwd");
             FileChannel channel = ra.getChannel();) {

            // Open the destination channel (copyChannel based on the random access file)
            RandomAccessFile copyFile = new RandomAccessFile("datacopy.txt", "rw");
            FileChannel copyChannel = copyFile.getChannel();

            // The start position is relative position, so set the current position to zero.
            channel.position(0);

            // Specify the source channel, the start position (which is a relative value)
            // and the number of bytes to copy and saving the numbe of transferred bytes
            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            System.out.println("Num transferred = " + numTransferred);

            // Close the channels and the random access file
            channel.close();
            ra.close();
            copyChannel.close();

        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public static void copyCalledFromTheSource() {
        try (RandomAccessFile ra = new RandomAccessFile("data.txt", "rwd");
             FileChannel channel = ra.getChannel();) {

            // Open the destination channel (copyChannel based on the random access file)
            RandomAccessFile copyFile = new RandomAccessFile("datacopy.txt", "rw");
            FileChannel copyChannel = copyFile.getChannel();

            // The start position is relative position, so set the current position to zero.
            channel.position(0);

            // Specify the source channel, the start position (which is a relative value)
            // and the number of bytes to copy and saving the numbe of transferred bytes
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred = " + numTransferred);

            // Close the channels and the random access file
            channel.close();
            ra.close();
            copyChannel.close();

        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        copyCalledFromTheSource();
    }

}