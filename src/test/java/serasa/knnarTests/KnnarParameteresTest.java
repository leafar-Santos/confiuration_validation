package serasa.knnarTests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import serasa.configurations.FilePathConfiguration;

public class KnnarParameteresTest {

    static JsonNode jsonNode;


    @BeforeClass
    public static void setup() throws IOException {
        File filePath = new File(FilePathConfiguration.getFilePath());
        ObjectMapper mapper = new ObjectMapper();
        jsonNode = mapper.readTree(filePath);
    }

    @Test
    public void deveValidarArrayFileds() {
        MatcherAssert.assertThat(jsonNode.get("fields").isArray(), Matchers.is(true));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).isArray(), Matchers.is(true));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).size(), Matchers.is(26));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(0).asText(), Matchers.is("monotonically_increasing_id() as id"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(1).asText(), Matchers.is("ID_EMAIL AS co_email"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(2).asText(), Matchers.is("CONTATOS_ID AS co_contatos"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(3).asText(), Matchers.is("EMAIL AS de_email"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(4).asText(), Matchers.is("PRIORIDADE AS co_prioridade"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(5).asText(), Matchers.is("EMAIL_SCORE AS co_email_score"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(6).asText(), Matchers.is("EMAIL_PESSOAL AS fl_email_pessoal"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(7).asText(), Matchers.is("EMAIL_DUPLICADO AS fl_email_duplicado"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(8).asText(), Matchers.is("BLACKLIST AS fl_blacklist"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(9).asText(), Matchers.is("ESTRUTURA AS fl_estrutura"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(10).asText(), Matchers.is("STATUS_VT AS de_st_retorno_email"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(11).asText(), Matchers.is("DOMINIO AS de_dominio"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(12).asText(), Matchers.is("MAPAS AS qt_ocorrencia_email_base_fornecedor"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(13).asText(), Matchers.is("PESO AS vl_peso"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(14).asText(), Matchers.is("CADASTRO_ID AS co_cadastro"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(15).asText(), Matchers.is("CASE WHEN DT_INCLUSAO is null THEN DATE_FORMAT(TO_DATE(\"01/01/2022\", \"dd/MM/yyyy\"), \"dd/MM/yyyy\") else DATE_FORMAT(DT_INCLUSAO, \"dd/MM/yyyy\") END As ts_inclusao"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(16).asText(), Matchers.is("EMAIL_PROCON AS fl_email_procon"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(17).asText(), Matchers.is("COMUNICADO_POSITIVO AS fl_comunicado_positivo"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(18).asText(), Matchers.is("EID AS fl_eid"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(19).asText(), Matchers.is("CNPJ_INFORMANTE AS nu_documento_informantee"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(20).asText(), Matchers.is("id_FINALIDADE AS co_finalidade"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(21).asText(), Matchers.is("dt_FINALIDADE_FORNECEDOR AS dt_finalidade_fornecedor"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(22).asText(), Matchers.is("de_MEIO_CAPTACAO_FORNECEDOR AS de_meio_captacao_fornecedor"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(23).asText(), Matchers.is("EMAIL_PRINCIPAL AS fl_email_principal"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(24).asText(), Matchers.is("de_FINALIDADE_FORNECEDOR AS de_finalidade_fornecedor"));
        MatcherAssert.assertThat(jsonNode.get("fields").get(0).get(25).asText(), Matchers.is("COMUNICADO_INADIMPLENCIA AS fl_comunicado_inadimplencia"));
    }

    @Test
    public void deveValidarPipelineOptions() {
        JsonNode dataPipelineOptions = jsonNode.get("dataPipeline");
        MatcherAssert.assertThat(dataPipelineOptions.toString(), Matchers.is("[]"));
    }

    @Test
    public void deveValidarPartitionBy() {
        JsonNode dataPartitionBy = jsonNode.get("partitionBy");
        MatcherAssert.assertThat(dataPartitionBy.toString(), Matchers.is("[]"));
    }

    @Test
    public void deveValidarDropDuplicates() {
        JsonNode dataDropDuplicates = jsonNode.get("dropDuplicates");
        MatcherAssert.assertThat(dataDropDuplicates.toString(), Matchers.is("[]"));
    }

    @Test
    public void deveValidarInputDataOptions() {
        JsonNode inputDataOptions = jsonNode.get("inputDataOptions");
        MatcherAssert.assertThat(inputDataOptions.get("encrypted").asText(), Matchers.is("false"));
        MatcherAssert.assertThat(inputDataOptions.get("format").asText(), Matchers.is("JDBC"));
        MatcherAssert.assertThat(inputDataOptions.get("optionsRead").get("partitionColumn").asText(), Matchers.is("ID_EMAIL"));
        MatcherAssert.assertThat(inputDataOptions.get("optionsRead").get("numPartitions").asText(), Matchers.is("20"));
        MatcherAssert.assertThat(inputDataOptions.get("optionsRead").get("url").asText(), CoreMatchers.containsString("jdbc:sqlserver://"));
        MatcherAssert.assertThat(inputDataOptions.get("optionsRead").get("driver").asText(), Matchers.is("com.microsoft.sqlserver.jdbc.SQLServerDriver"));
    }

    @Test
    public void deveValidarBucketName() {
        MatcherAssert.assertThat(jsonNode.get("bucketName").asText(), Matchers.is("datahub-cadastral-input-prod"));
    }

    @Test
    public void deveValidarOutputFmtData() {
        JsonNode outputFmtData = jsonNode.get("outputFmtData");
        MatcherAssert.assertThat(outputFmtData.get("format").asText(), Matchers.is("PARQUET"));
        MatcherAssert.assertThat(outputFmtData.get("outputModeParquet").asText(), Matchers.is("overwrite"));
        MatcherAssert.assertThat(outputFmtData.get("outputParquetPath").asText(), Matchers.is("s3://datahub-cadastral-input-prod/projetos/batimento/stage/email"));
        MatcherAssert.assertThat(outputFmtData.get("encrypted").asText(), Matchers.is("false"));
        MatcherAssert.assertThat(outputFmtData.get("optionsWrite").toString(), Matchers.is("{}"));
    }
}
