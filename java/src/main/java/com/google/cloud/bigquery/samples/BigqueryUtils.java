package com.google.cloud.bigquery.samples;

import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.Bigquery.Datasets;
import com.google.api.services.bigquery.Bigquery.Jobs.GetQueryResults;
import com.google.api.services.bigquery.model.DatasetList;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.TableCell;
import com.google.api.services.bigquery.model.TableRow;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO: Insert description here. (generated by elibixby)
 */
public class BigqueryUtils {
  
  // [START print_rows]
  public static void printRows(List<TableRow> rows, PrintStream out){
    for (TableRow row : rows) {
      for (TableCell field : row.getF()) {
        out.printf("%-50s", field.getV());
       }
      out.println();
    }
  }
  // [END print_rows]
  
  // [START poll_job]
  public static Job pollJob(Bigquery.Jobs.Get request, long interval)
      throws IOException, InterruptedException{
    Job job = request.execute();
    while(!job.getStatus().getState().equals("DONE")) {
      Thread.sleep(interval);
    }
    return job;
  }
  // [END poll_job]
  
  // [START query_paging]
  public static Iterator<List<TableRow>> getPages(GetQueryResults request_template){

    class PageIterator implements Iterator<List<TableRow>>{

      GetQueryResults request;

      public PageIterator(GetQueryResults request_template){
        this.request = request_template;
      }


      public boolean hasNext() {
        return request.getPageToken() != null;
      }
      public List<TableRow> next() {
        try {
          GetQueryResultsResponse response =request.execute();
          request = request.setPageToken(response.getPageToken());
          return response.getRows();
        } catch (IOException e) {
          e.printStackTrace();
          return new ArrayList<TableRow>();
        }
      }
      public void remove() {
        this.next();
      } 
    }

    return new PageIterator(request_template);
  }
  // [END query_paging]
  
  
  // [START list_datasets]
  /**
   * Display all BigQuery datasets associated with a project
   *
   * @param bigquery  an authorized BigQuery client
   * @param projectId a string containing the current project ID
   * @throws IOException
   */
  public static void listDatasets(Bigquery bigquery, String projectId)
      throws IOException {
    Datasets.List datasetRequest = bigquery.datasets().list(projectId);
    DatasetList datasetList = datasetRequest.execute();
    if (datasetList.getDatasets() != null) {
      List<DatasetList.Datasets> datasets = datasetList.getDatasets();
      System.out.println("Available datasets\n----------------");
      System.out.println(datasets.toString());
      for (DatasetList.Datasets dataset : datasets) {
        System.out.format("%s\n", dataset.getDatasetReference().getDatasetId());
      }
    }
  }
  // [END list_datasets]
  
}
