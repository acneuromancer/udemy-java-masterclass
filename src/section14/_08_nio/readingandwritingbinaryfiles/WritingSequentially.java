package section14._08_nio.readingandwritingbinaryfiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WritingSequentially {

    public static void main(String[] args) {

//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
//            buffer.flip();

//            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource

        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            // Calculate the start positions
            byte[] outputString = "Hello, World!".getBytes();
            long str1Pos = 0;
            long int1Pos = outputString.length;
            long int2Pos = int1Pos + Integer.BYTES;
            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = int2Pos + Integer.BYTES;
            long int3Pos = str2Pos + outputString2.length;

            // Write the integers
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(int1Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            binChannel.position(int2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(int3Pos);
            binChannel.write(intBuffer);

            // Write the strings
            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));

            // Read in the data from the file
            RandomAccessFile randomAccessFile = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = randomAccessFile.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();

            byte[] inputString = new byte[outputString.length];
            readBuffer.get(inputString);
            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputString2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());

            channel.close();
            randomAccessFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
