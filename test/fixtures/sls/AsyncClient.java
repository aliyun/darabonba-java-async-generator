package com.aliyun.sls20201230;

import com.aliyun.sls20201230.models.*;
import darabonba.core.async.*;
import darabonba.core.sync.*;

import java.util.concurrent.CompletableFuture;

public interface AsyncClient {

    static DefaultAsyncClientBuilder builder() {
        return new DefaultAsyncClientBuilder();
    }

    static AsyncClient create() {
        return builder().build();
    }

    CompletableFuture<GetExternalStoreResponse> getExternalStore(GetExternalStoreRequest request);

    CompletableFuture<DeleteLogstoreResponse> deleteLogstore(DeleteLogstoreRequest request);

    CompletableFuture<ListMachineGroupResponse> listMachineGroup(ListMachineGroupRequest request);

    CompletableFuture<GetCursorTimeResponse> getCursorTime(GetCursorTimeRequest request);

    CompletableFuture<DeleteConfigResponse> deleteConfig(DeleteConfigRequest request);

    CompletableFuture<EnableReportResponse> enableReport(EnableReportRequest request);

    CompletableFuture<RetryShipperTasksResponse> retryShipperTasks(RetryShipperTasksRequest request);

    CompletableFuture<CreateMachineGroupResponse> createMachineGroup(CreateMachineGroupRequest request);

    CompletableFuture<GetMachineGroupResponse> getMachineGroup(GetMachineGroupRequest request);

    CompletableFuture<DeleteRebuildIndexResponse> deleteRebuildIndex(DeleteRebuildIndexRequest request);

    CompletableFuture<DeleteShardResponse> deleteShard(DeleteShardRequest request);

    CompletableFuture<GetContextLogsResponse> getContextLogs(GetContextLogsRequest request);

    CompletableFuture<CreateDashboardResponse> createDashboard(CreateDashboardRequest request);

    CompletableFuture<DeleteIngestionResponse> deleteIngestion(DeleteIngestionRequest request);

    CompletableFuture<StartExportResponse> startExport(StartExportRequest request);

    CompletableFuture<CreateLogStoreInternalResponse> createLogStoreInternal(CreateLogStoreInternalRequest request);

    CompletableFuture<GetLogstoreResponse> getLogstore(GetLogstoreRequest request);

    CompletableFuture<UpdateJobScheduleResponse> updateJobSchedule(UpdateJobScheduleRequest request);

    CompletableFuture<UpdateMachineGroupResponse> updateMachineGroup(UpdateMachineGroupRequest request);

    CompletableFuture<GetCheckPointResponse> getCheckPoint(GetCheckPointRequest request);

    CompletableFuture<ListDomainsResponse> listDomains(ListDomainsRequest request);

    CompletableFuture<DeleteEtlJobResponse> deleteEtlJob(DeleteEtlJobRequest request);

    CompletableFuture<GetIngestionResponse> getIngestion(GetIngestionRequest request);

    CompletableFuture<CreateRebuildIndexResponse> createRebuildIndex(CreateRebuildIndexRequest request);

    CompletableFuture<ListShipperResponse> listShipper(ListShipperRequest request);

    CompletableFuture<DeleteChartResponse> deleteChart(DeleteChartRequest request);

    CompletableFuture<DisableAlertResponse> disableAlert(DisableAlertRequest request);

    CompletableFuture<DeleteReportResponse> deleteReport(DeleteReportRequest request);

    CompletableFuture<GetProjectResponse> getProject(GetProjectRequest request);

    CompletableFuture<StartJobScheduleResponse> startJobSchedule(StartJobScheduleRequest request);

    CompletableFuture<ApproveMachineGroupResponse> approveMachineGroup(ApproveMachineGroupRequest request);

    CompletableFuture<DeleteJobScheduleResponse> deleteJobSchedule(DeleteJobScheduleRequest request);

    CompletableFuture<StopIngestionResponse> stopIngestion(StopIngestionRequest request);

    CompletableFuture<GetCursorResponse> getCursor(GetCursorRequest request);

    CompletableFuture<DeleteProjectResponse> deleteProject(DeleteProjectRequest request);

    CompletableFuture<DeleteConsumerGroupResponse> deleteConsumerGroup(DeleteConsumerGroupRequest request);

    CompletableFuture<GetExportResponse> getExport(GetExportRequest request);

    CompletableFuture<CreateLogstoreResponse> createLogstore(CreateLogstoreRequest request);

    CompletableFuture<GetDashboardResponse> getDashboard(GetDashboardRequest request);

    CompletableFuture<ListJobsResponse> listJobs(ListJobsRequest request);

    CompletableFuture<GetJobScheduleResponse> getJobSchedule(GetJobScheduleRequest request);

    CompletableFuture<GetProjectLogsResponse> getProjectLogs(GetProjectLogsRequest request);

    CompletableFuture<UpdateReportResponse> updateReport(UpdateReportRequest request);

    CompletableFuture<GetJobResponse> getJob(GetJobRequest request);

    CompletableFuture<CreateProjectResponse> createProject(CreateProjectRequest request);

    CompletableFuture<UpdateEtlMetaResponse> updateEtlMeta(UpdateEtlMetaRequest request);

    CompletableFuture<PullLogsResponse> pullLogs(PullLogsRequest request);

    CompletableFuture<CreateChartResponse> createChart(CreateChartRequest request);

    CompletableFuture<GetLoggingResponse> getLogging(GetLoggingRequest request);

    CompletableFuture<CreateLoggingResponse> createLogging(CreateLoggingRequest request);

    CompletableFuture<GetIndexResponse> getIndex(GetIndexRequest request);

    CompletableFuture<ListShardsResponse> listShards(ListShardsRequest request);

    CompletableFuture<ListSavedSearchResponse> listSavedSearch(ListSavedSearchRequest request);

    CompletableFuture<GetEtlMetaResponse> getEtlMeta(GetEtlMetaRequest request);

    CompletableFuture<ApplyConfigToMachineGroupResponse> applyConfigToMachineGroup(ApplyConfigToMachineGroupRequest request);

    CompletableFuture<GetChartResponse> getChart(GetChartRequest request);

    CompletableFuture<UpdateDashboardResponse> updateDashboard(UpdateDashboardRequest request);

    CompletableFuture<GetRebuildIndexResponse> getRebuildIndex(GetRebuildIndexRequest request);

    CompletableFuture<UpdateJobResponse> updateJob(UpdateJobRequest request);

    CompletableFuture<CreateJobScheduleResponse> createJobSchedule(CreateJobScheduleRequest request);

    CompletableFuture<CreateExportResponse> createExport(CreateExportRequest request);

    CompletableFuture<GetIndexStringResponse> getIndexString(GetIndexStringRequest request);

    CompletableFuture<ListConfigResponse> listConfig(ListConfigRequest request);

    CompletableFuture<DeleteShipperResponse> deleteShipper(DeleteShipperRequest request);

    CompletableFuture<RemoveConfigFromMachineGroupResponse> removeConfigFromMachineGroup(RemoveConfigFromMachineGroupRequest request);

    CompletableFuture<StopJobScheduleResponse> stopJobSchedule(StopJobScheduleRequest request);

    CompletableFuture<GetShipperConfigResponse> getShipperConfig(GetShipperConfigRequest request);

    CompletableFuture<UpdateAlertResponse> updateAlert(UpdateAlertRequest request);

    CompletableFuture<UpdateLogstoreResponse> updateLogstore(UpdateLogstoreRequest request);

    CompletableFuture<DeleteExternalStoreResponse> deleteExternalStore(DeleteExternalStoreRequest request);

    CompletableFuture<BatchUpdateEtlMetaResponse> batchUpdateEtlMeta(BatchUpdateEtlMetaRequest request);

    CompletableFuture<AddMachineIntoMachineGroupResponse> addMachineIntoMachineGroup(AddMachineIntoMachineGroupRequest request);

    CompletableFuture<GetETLResponse> getETL(GetETLRequest request);

    CompletableFuture<UpdateIndexResponse> updateIndex(UpdateIndexRequest request);

    CompletableFuture<ListLogStoresResponse> listLogStores(ListLogStoresRequest request);

    CompletableFuture<UpdateShipperResponse> updateShipper(UpdateShipperRequest request);

    CompletableFuture<CreateSavedSearchResponse> createSavedSearch(CreateSavedSearchRequest request);

    CompletableFuture<UpdateSavedSearchResponse> updateSavedSearch(UpdateSavedSearchRequest request);

    CompletableFuture<ListEtlMetaNameResponse> listEtlMetaName(ListEtlMetaNameRequest request);

    CompletableFuture<CreateEtlJobResponse> createEtlJob(CreateEtlJobRequest request);

    CompletableFuture<UpdateLogStoreInternalResponse> updateLogStoreInternal(UpdateLogStoreInternalRequest request);

    CompletableFuture<CreateDomainResponse> createDomain(CreateDomainRequest request);

    CompletableFuture<ListLogstoreResponse> listLogstore(ListLogstoreRequest request);

    CompletableFuture<ListRebuildIndexResponse> listRebuildIndex(ListRebuildIndexRequest request);

    CompletableFuture<ListTopicsResponse> listTopics(ListTopicsRequest request);

    CompletableFuture<StartIngestionResponse> startIngestion(StartIngestionRequest request);

    CompletableFuture<ListConsumerGroupResponse> listConsumerGroup(ListConsumerGroupRequest request);

    CompletableFuture<DisableJobResponse> disableJob(DisableJobRequest request);

    CompletableFuture<GetShipperStatusResponse> getShipperStatus(GetShipperStatusRequest request);

    CompletableFuture<UpdateMachineGroupMachineResponse> updateMachineGroupMachine(UpdateMachineGroupMachineRequest request);

    CompletableFuture<DeleteExportResponse> deleteExport(DeleteExportRequest request);

    CompletableFuture<GetAppliedMachineGroupsResponse> getAppliedMachineGroups(GetAppliedMachineGroupsRequest request);

    CompletableFuture<ListEtlJobResponse> listEtlJob(ListEtlJobRequest request);

    CompletableFuture<DeleteIndexResponse> deleteIndex(DeleteIndexRequest request);

    CompletableFuture<DeleteMachineFromMachineGroupResponse> deleteMachineFromMachineGroup(DeleteMachineFromMachineGroupRequest request);

    CompletableFuture<CreateConsumerGroupResponse> createConsumerGroup(CreateConsumerGroupRequest request);

    CompletableFuture<ListJobSchedulesResponse> listJobSchedules(ListJobSchedulesRequest request);

    CompletableFuture<ListIngestionResponse> listIngestion(ListIngestionRequest request);

    CompletableFuture<DeleteSavedSearchResponse> deleteSavedSearch(DeleteSavedSearchRequest request);

    CompletableFuture<ListReportResponse> listReport(ListReportRequest request);

    CompletableFuture<CreateExternalStoreResponse> createExternalStore(CreateExternalStoreRequest request);

    CompletableFuture<BatchGetLogResponse> batchGetLog(BatchGetLogRequest request);

    CompletableFuture<UpdateConfigResponse> updateConfig(UpdateConfigRequest request);

    CompletableFuture<HeartBeatResponse> heartBeat(HeartBeatRequest request);

    CompletableFuture<UpdateACLResponse> updateACL(UpdateACLRequest request);

    CompletableFuture<GetSavedSearchResponse> getSavedSearch(GetSavedSearchRequest request);

    CompletableFuture<StopRebuildIndexResponse> stopRebuildIndex(StopRebuildIndexRequest request);

    CompletableFuture<DeleteAlertResponse> deleteAlert(DeleteAlertRequest request);

    CompletableFuture<DeleteDashboardResponse> deleteDashboard(DeleteDashboardRequest request);

    CompletableFuture<ListExternalStoreResponse> listExternalStore(ListExternalStoreRequest request);

    CompletableFuture<ListDashboardResponse> listDashboard(ListDashboardRequest request);

    CompletableFuture<ListMachinesResponse> listMachines(ListMachinesRequest request);

    CompletableFuture<UpdateCheckPointResponse> updateCheckPoint(UpdateCheckPointRequest request);

    CompletableFuture<UpdateETLResponse> updateETL(UpdateETLRequest request);

    CompletableFuture<MergeShardsResponse> mergeShards(MergeShardsRequest request);

    CompletableFuture<BatchModifyEtlMetaStatusResponse> batchModifyEtlMetaStatus(BatchModifyEtlMetaStatusRequest request);

    CompletableFuture<CreateReportResponse> createReport(CreateReportRequest request);

    CompletableFuture<ClearLogStoreStorageResponse> clearLogStoreStorage(ClearLogStoreStorageRequest request);

    CompletableFuture<GetLogsResponse> getLogs(GetLogsRequest request);

    CompletableFuture<DeleteEtlMetaResponse> deleteEtlMeta(DeleteEtlMetaRequest request);

    CompletableFuture<UpdateExternalStoreResponse> updateExternalStore(UpdateExternalStoreRequest request);

    CompletableFuture<CreateConfigResponse> createConfig(CreateConfigRequest request);

    CompletableFuture<GetEtlJobResponse> getEtlJob(GetEtlJobRequest request);

    CompletableFuture<CreateShipperResponse> createShipper(CreateShipperRequest request);

    CompletableFuture<DeleteETLResponse> deleteETL(DeleteETLRequest request);

    CompletableFuture<DeleteLoggingResponse> deleteLogging(DeleteLoggingRequest request);

    CompletableFuture<BatchCreateEtlMetaResponse> batchCreateEtlMeta(BatchCreateEtlMetaRequest request);

    CompletableFuture<GetAlertResponse> getAlert(GetAlertRequest request);

    CompletableFuture<StopExportResponse> stopExport(StopExportRequest request);

    CompletableFuture<GetConfigResponse> getConfig(GetConfigRequest request);

    CompletableFuture<EnableJobResponse> enableJob(EnableJobRequest request);

    CompletableFuture<PutWebtrackingResponse> putWebtracking(PutWebtrackingRequest request);

    CompletableFuture<CreateIndexResponse> createIndex(CreateIndexRequest request);

    CompletableFuture<UpdateChartResponse> updateChart(UpdateChartRequest request);

    CompletableFuture<GetReportResponse> getReport(GetReportRequest request);

    CompletableFuture<GetAppliedConfigsResponse> getAppliedConfigs(GetAppliedConfigsRequest request);

    CompletableFuture<CreateEtlMetaResponse> createEtlMeta(CreateEtlMetaRequest request);

    CompletableFuture<DeleteJobResponse> deleteJob(DeleteJobRequest request);

    CompletableFuture<SplitShardResponse> splitShard(SplitShardRequest request);

    CompletableFuture<ListProjectResponse> listProject(ListProjectRequest request);

    CompletableFuture<UpdateConsumerGroupResponse> updateConsumerGroup(UpdateConsumerGroupRequest request);

    CompletableFuture<GetHistogramsResponse> getHistograms(GetHistogramsRequest request);

    CompletableFuture<UpdateExportResponse> updateExport(UpdateExportRequest request);

    CompletableFuture<EnableAlertResponse> enableAlert(EnableAlertRequest request);

    CompletableFuture<UpdateLoggingResponse> updateLogging(UpdateLoggingRequest request);

    CompletableFuture<DisableReportResponse> disableReport(DisableReportRequest request);

    CompletableFuture<ListAlertResponse> listAlert(ListAlertRequest request);

    CompletableFuture<ListETLResponse> listETL(ListETLRequest request);

    CompletableFuture<UpdateEtlJobResponse> updateEtlJob(UpdateEtlJobRequest request);

    CompletableFuture<DeleteDomainResponse> deleteDomain(DeleteDomainRequest request);

    CompletableFuture<CreateAlertResponse> createAlert(CreateAlertRequest request);

    CompletableFuture<UpdateProjectResponse> updateProject(UpdateProjectRequest request);

    CompletableFuture<RetryShipperTaskResponse> retryShipperTask(RetryShipperTaskRequest request);

    CompletableFuture<ListExportResponse> listExport(ListExportRequest request);

    CompletableFuture<DeleteMachineGroupResponse> deleteMachineGroup(DeleteMachineGroupRequest request);

    CompletableFuture<GetShipperTasksResponse> getShipperTasks(GetShipperTasksRequest request);

    CompletableFuture<ListACLResponse> listACL(ListACLRequest request);

    CompletableFuture<UpdateIngestionResponse> updateIngestion(UpdateIngestionRequest request);

    CompletableFuture<CreateETLResponse> createETL(CreateETLRequest request);

    CompletableFuture<CreateIngestionResponse> createIngestion(CreateIngestionRequest request);

}
