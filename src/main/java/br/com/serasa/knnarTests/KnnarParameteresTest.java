package br.com.serasa.knnarTests;
import br.com.serasa.configurations.FilePathConfiguration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class KnnarParameteresTest {

    static JsonNode jsonNode;

    @BeforeClass
    public static void setup() throws IOException {

        File file = new File(FilePathConfiguration.getFilePath());
        ObjectMapper mapper = new ObjectMapper();
        jsonNode = mapper.readTree(file);
    }

    @Test
    public void deveValidarArrayFileds() {

        assertThat(jsonNode.get("fields").isArray(), is(true));
        assertThat(jsonNode.get("fields").get(0).isArray(), is(true));
        assertThat(jsonNode.get("fields").get(0).size(), is(26));


        // Validar todos os atributos na sequencia na lista de fields
        assertThat(jsonNode.get("fields").get(0).get(0).asText(), is("monotonically_increasing_id() as id"));
        assertThat(jsonNode.get("fields").get(0).get(1).asText(), is("ID_EMAIL AS co_email"));
        assertThat(jsonNode.get("fields").get(0).get(2).asText(), is("CONTATOS_ID AS co_contatos"));
        assertThat(jsonNode.get("fields").get(0).get(3).asText(), is("EMAIL AS de_email"));
        assertThat(jsonNode.get("fields").get(0).get(4).asText(), is("PRIORIDADE AS co_prioridade"));
        assertThat(jsonNode.get("fields").get(0).get(5).asText(), is("EMAIL_SCORE AS co_email_score"));
        assertThat(jsonNode.get("fields").get(0).get(6).asText(), is("EMAIL_PESSOAL AS fl_email_pessoal"));
        assertThat(jsonNode.get("fields").get(0).get(7).asText(), is("EMAIL_DUPLICADO AS fl_email_duplicado"));
        assertThat(jsonNode.get("fields").get(0).get(8).asText(), is("BLACKLIST AS fl_blacklist"));
        assertThat(jsonNode.get("fields").get(0).get(9).asText(), is("ESTRUTURA AS fl_estrutura"));
        assertThat(jsonNode.get("fields").get(0).get(10).asText(), is("STATUS_VT AS de_st_retorno_email"));
        assertThat(jsonNode.get("fields").get(0).get(11).asText(), is("DOMINIO AS de_dominio"));
        assertThat(jsonNode.get("fields").get(0).get(12).asText(), is("MAPAS AS qt_ocorrencia_email_base_fornecedor"));
        assertThat(jsonNode.get("fields").get(0).get(13).asText(), is("PESO AS vl_peso"));
        assertThat(jsonNode.get("fields").get(0).get(14).asText(), is("CADASTRO_ID AS co_cadastro"));
        assertThat(jsonNode.get("fields").get(0).get(15).asText(), is("CASE WHEN DT_INCLUSAO is null THEN DATE_FORMAT(TO_DATE(\"01/01/2022\", \"dd/MM/yyyy\"), \"dd/MM/yyyy\") else DATE_FORMAT(DT_INCLUSAO, \"dd/MM/yyyy\") END As ts_inclusao"));
        assertThat(jsonNode.get("fields").get(0).get(16).asText(), is("EMAIL_PROCON AS fl_email_procon"));
        assertThat(jsonNode.get("fields").get(0).get(17).asText(), is("COMUNICADO_POSITIVO AS fl_comunicado_positivo"));
        assertThat(jsonNode.get("fields").get(0).get(18).asText(), is("EID AS fl_eid"));
        assertThat(jsonNode.get("fields").get(0).get(19).asText(), is("CNPJ_INFORMANTE AS nu_documento_informantee"));
        assertThat(jsonNode.get("fields").get(0).get(20).asText(), is("id_FINALIDADE AS co_finalidade"));
        assertThat(jsonNode.get("fields").get(0).get(21).asText(), is("dt_FINALIDADE_FORNECEDOR AS dt_finalidade_fornecedor"));
        assertThat(jsonNode.get("fields").get(0).get(22).asText(), is("de_MEIO_CAPTACAO_FORNECEDOR AS de_meio_captacao_fornecedor"));
        assertThat(jsonNode.get("fields").get(0).get(23).asText(), is("EMAIL_PRINCIPAL AS fl_email_principal"));
        assertThat(jsonNode.get("fields").get(0).get(24).asText(), is("de_FINALIDADE_FORNECEDOR AS de_finalidade_fornecedor"));
        assertThat(jsonNode.get("fields").get(0).get(25).asText(), is("COMUNICADO_INADIMPLENCIA AS fl_comunicado_inadimplencia"));
    }

    @Test
    public void deveValidarPipelineOptions() {
        JsonNode dataPipelineOptions = jsonNode.get("dataPipeline");
        assertThat(dataPipelineOptions.toString(), is("[{}]"));
    }


    @Test
    public void deveValidarPartitionBy() {
        JsonNode dataPartitionBy = jsonNode.get("partitionBy");
        assertThat(dataPartitionBy.toString(), is("[]"));
    }

    @Test
    public void deveValidarDropDuplicates() {
        JsonNode dataDropDuplicates = jsonNode.get("dropDuplicates");
        assertThat(dataDropDuplicates.toString(), is("[]"));

    }

    @Test
    public void deveValidarInputDataOptions() {

        JsonNode inputDataOptions = jsonNode.get("inputDataOptions");
        assertThat(inputDataOptions.get("encrypted").asText(), is("false"));
        assertThat(inputDataOptions.get("format").asText(), is("JDBC"));
        assertThat(inputDataOptions.get("optionsRead").get("partitionColumn").asText(), is("ID_EMAIL"));
        assertThat(inputDataOptions.get("optionsRead").get("numPartitions").asText(), is("20"));
        assertThat(inputDataOptions.get("optionsRead").get("url").asText(), containsString("jdbc:sqlserver://"));
        assertThat(inputDataOptions.get("optionsRead").get("driver").asText(), is("com.microsoft.sqlserver.jdbc.SQLServerDriver"));

    }

    @Test
    public void deveValidarBucketName() {
        assertThat(jsonNode.get("bucketName").asText(), is("datahub-cadastral-input-prod"));
    }

    @Test
    public void deveValidarOutputFmtData() {

        JsonNode outputFmtData = jsonNode.get("outputFmtData");
        assertThat(outputFmtData.get("format").asText(), is("PARQUET"));
        assertThat(outputFmtData.get("outputModeParquet").asText(), is("overwrite"));
        assertThat(outputFmtData.get("outputParquetPath").asText(), is("s3://datahub-cadastral-input-prod/projetos/batimento/stage/email"));
        assertThat(outputFmtData.get("encrypted").asText(), is("false"));
        assertThat(outputFmtData.get("optionsWrite").toString(), is("{}"));

    }

}