package com.smartdevicelink.test.protocol;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.smartdevicelink.protocol.BinaryQueryHeader;
import com.smartdevicelink.protocol.enums.QueryID;
import com.smartdevicelink.util.BitConverter;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class BinaryQueryHeaderTests {

    public static final byte QUERY_TYPE_REQUEST = 0x00;
    public static final byte QUERY_TYPE_RESPONSE = 0x01;
    public static final byte QUERY_TYPE_NOTIFICATION = 0x02;

    public static BinaryQueryHeader createDummyBqh() {
        BinaryQueryHeader bqh = new BinaryQueryHeader();
        bqh.setCorrelationID(123);
        bqh.setQueryID(QueryID.SEND_HANDSHAKE_DATA.getValue());
        bqh.setQueryType(QUERY_TYPE_REQUEST);
        bqh.setBulkData(null);
        bqh.setJsonSize(0);
        return bqh;
    }

    public BinaryQueryHeader safeParse(byte[] array) {
        try {
            return BinaryQueryHeader.parseBinaryQueryHeader(array);
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void testCorrectParsing() {
        byte[] array = new byte[12];
        array[0] = 1;
        array[1] = 0;
        array[2] = 0;
        array[3] = 2;
        array[4] = 0;
        array[5] = 0;
        array[6] = 0;
        array[7] = 3;
        array[8] = 0;
        array[9] = 0;
        array[10] = 0;
        array[11] = 0;

        BinaryQueryHeader parsedBqh = BinaryQueryHeader.parseBinaryQueryHeader(array);
        assertEquals(parsedBqh.getQueryType(), 0x1);
        assertEquals(parsedBqh.getQueryID(), 2);
        assertEquals(parsedBqh.getCorrelationID(), 3);
        assertEquals(parsedBqh.getJsonSize(), 0);
    }

    @Test
    public void testCorrectHeaderAssembly() {
        BinaryQueryHeader dummyBqh = new BinaryQueryHeader();
        dummyBqh.setQueryType((byte) 1);
        dummyBqh.setQueryID(2);
        dummyBqh.setCorrelationID(3);
        dummyBqh.setJsonSize(0);

        byte[] assembledHeader = dummyBqh.assembleHeaderBytes();
        assertEquals(dummyBqh.getQueryType(), assembledHeader[0]);
        assertEquals(dummyBqh.getQueryID(), BitConverter.intFromByteArray(assembledHeader, 0) & 0x00FFFFFF);
        assertEquals(dummyBqh.getCorrelationID(), BitConverter.intFromByteArray(assembledHeader, 4));
        assertEquals(dummyBqh.getJsonSize(), BitConverter.intFromByteArray(assembledHeader, 8));
    }

    @Test
    public void testAssemblyAndParse() {
        BinaryQueryHeader bqh = createDummyBqh();

        byte[] bqhBytes = bqh.assembleHeaderBytes();
        assertNotNull(bqhBytes);

        BinaryQueryHeader parsedBqh = BinaryQueryHeader.parseBinaryQueryHeader(bqhBytes);
        assertNotNull(parsedBqh);

        assertEquals(bqh.getCorrelationID(), parsedBqh.getCorrelationID());
        assertEquals(bqh.getQueryID(), parsedBqh.getQueryID());
        assertEquals(bqh.getQueryType(), parsedBqh.getQueryType());
        assertEquals(bqh.getBulkData(), parsedBqh.getBulkData());
        assertEquals(bqh.getJsonData(), parsedBqh.getJsonData());
        assertEquals(bqh.getJsonSize(), parsedBqh.getJsonSize());
    }

    @Test
    public void testCorruptHeader() {
        BinaryQueryHeader bqh = createDummyBqh();
        bqh.setJsonSize(5);
        bqh.setJsonData(new byte[5]);
        bqh.setJsonSize(Integer.MAX_VALUE);

        assertNotEquals(bqh.getJsonData().length, bqh.getJsonSize());

        byte[] bqhBytes = bqh.assembleHeaderBytes();

        assertNull(safeParse(bqhBytes));

        int size = bqhBytes.length;
        for (int i = 0; i < size; i++) {
            bqhBytes[i] = (byte) 0x99;
        }

        assertNull(safeParse(bqhBytes));
        BinaryQueryHeader head = BinaryQueryHeader.parseBinaryQueryHeader(bqhBytes);
        assertNull(head);
    }

    @Test
    public void testJsonSetException() {
        try {
            BinaryQueryHeader bqh = createDummyBqh();
            bqh.setJsonData(null);
            fail("Setting JSON data to null should have thrown an exception");
        } catch (Exception e) {
            //Pass
        }
    }
}
