package com.google.cloud.bigquery.samples.test;

import static org.junit.Assert.*;

import com.google.api.services.bigquery.model.TableRow;
import com.google.cloud.bigquery.samples.SyncQuerySample;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


/**
 * TODO: Insert description here. (generated by elibixby)
 */
public class SyncQuerySampleTest extends BigquerySampleTest {

  /**
   * @throws JsonSyntaxException
   * @throws JsonIOException
   * @throws FileNotFoundException
   */
  protected SyncQuerySampleTest() throws JsonSyntaxException, JsonIOException,
      FileNotFoundException {
    super();
  }

  @Test
  public void testSyncQuery() throws IOException{
    Iterator<List<TableRow>> queryPages = SyncQuerySample.run(
        CONSTANTS.getProjectId(),
        CONSTANTS.getQuery(),
        10000);
    
    assertTrue(queryPages.hasNext());
  }
  
}
