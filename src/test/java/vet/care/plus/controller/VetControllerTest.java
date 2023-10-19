package vet.care.plus.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import vet.care.plus.domain.dto.DadosPessoaisDto;
import vet.care.plus.domain.dto.EnderecoDto;
import vet.care.plus.domain.dto.vet.DetalhamentoVetDto;
import vet.care.plus.domain.model.DadosPessoais;
import vet.care.plus.domain.model.Endereco;
import vet.care.plus.domain.model.vet.Especialidade;
import vet.care.plus.service.VetService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class VetControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<CadastroVetDtoTest> cadastroVetDtoJson;

    @Autowired
    private JacksonTester<DetalhamentoVetDto> detalhamentoVetDtoJson;

    @MockBean
    private VetService service;

    @Test
    @DisplayName("Deve retornar código 400 quando a requisição for invalida.")
    void cadastrar_cenario1() throws Exception {
        var response = mvc.perform(post("/vet"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve retornar código 200 quando a requisição for processada com sucesso.")
    void cadastrar_cenario2() throws Exception {
        var response = mvc.perform(post("/vet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                cadastroVetDtoJson.write(
                                        new CadastroVetDtoTest(
                                                1l,
                                                new DadosPessoaisDto(
                                                        "joão da silva",
                                                        "joao_silva@vetcare.com",
                                                        "21912345678",
                                                        "12345678900",
                                                        "M"),
                                                "123456",
                                                Especialidade.ACUPUNTURA,
                                                new EnderecoDto(
                                                        "12345678",
                                                        "rua a",
                                                        "complemento b",
                                                        "bairro c",
                                                        "123",
                                                        "cidade d",
                                                        "EF"))).getJson()))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deve retornar código 200 OK e um json esperado quando a URI for válida.")
    void detalhar_cenario1() throws Exception {

        var detalhamentoVet = new DetalhamentoVetDto(
                1l,
                new DadosPessoais(
                "joao da silva",
                "joao_silva@vetcare.com",
                "21912345678",
                "12345678900",
                "M"
        ), "123456",
                Especialidade.ACUPUNTURA,
                new Endereco(
                "12345678",
                "rua a",
                "complemento b",
                "bairro c",
                "123",
                "cidade d",
                "EF"
        ), true);

        when(service.detalhar(1l)).thenReturn(detalhamentoVet);

        var responsePost = mvc.perform(post("/vet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                cadastroVetDtoJson.write(
                                        new CadastroVetDtoTest(
                                                1l,
                                                new DadosPessoaisDto(
                                                        "joao da silva",
                                                        "joao_silva@vetcare.com",
                                                        "21912345678",
                                                        "12345678900",
                                                        "M"),
                                                "123456",
                                                Especialidade.ACUPUNTURA,
                                                new EnderecoDto(
                                                        "12345678",
                                                        "rua a",
                                                        "complemento b",
                                                        "bairro c",
                                                        "123",
                                                        "cidade d",
                                                        "EF"))).getJson()))
                .andReturn();
        var responseGet = mvc.perform(get("/vet/1"))
                .andReturn().getResponse();
        assertThat(responseGet.getStatus()).isEqualTo(HttpStatus.OK.value());

            var jsonEsperado = detalhamentoVetDtoJson.write(detalhamentoVet).getJson();

            assertThat(responseGet.getContentAsString()).isEqualTo(jsonEsperado);

    }

    @Test
    @DisplayName("Deve retornar um JSON vazio quando a URI for inválida.")
    void detalhar_cenario2() throws Exception {

        var detalhamentoVet = new DetalhamentoVetDto(
                1l,
                new DadosPessoais(
                        "joao da silva",
                        "joao_silva@vetcare.com",
                        "21912345678",
                        "12345678900",
                        "M"
                ),
                "123456",
                Especialidade.ACUPUNTURA,
                new Endereco(
                        "12345678",
                        "rua a",
                        "complemento b",
                        "bairro c",
                        "123",
                        "cidade d",
                        "EF"
                ),
                true);

        when(service.detalhar(1l)).thenReturn(detalhamentoVet);

        var responsePost = mvc.perform(post("/vet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                cadastroVetDtoJson.write(
                                        new CadastroVetDtoTest(
                                                1l,
                                                new DadosPessoaisDto(
                                                        "joao da silva",
                                                        "joao_silva@vetcare.com",
                                                        "21912345678",
                                                        "12345678900",
                                                        "M"),
                                                "123456",
                                                Especialidade.ACUPUNTURA,
                                                new EnderecoDto(
                                                        "12345678",
                                                        "rua a",
                                                        "complemento b",
                                                        "bairro c",
                                                        "123",
                                                        "cidade d",
                                                        "EF"))).getJson()))
                .andReturn();

        var responseGet = mvc.perform(get("/vet/5"))
                .andReturn().getResponse();

        assertThat(responseGet.getContentAsString()).isEmpty();
    }

    public record CadastroVetDtoTest(Long id, DadosPessoaisDto dadosPessoais, String crmv, Especialidade especialidade, EnderecoDto endereco) {

    }

}