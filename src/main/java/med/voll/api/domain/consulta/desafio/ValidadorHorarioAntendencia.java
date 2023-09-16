package med.voll.api.domain.consulta.desafio;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntendenciaCancelamiento")
public class ValidadorHorarioAntendencia implements ValidadorCancelamientoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosCancelamientoConsulta datos){
        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora, consulta.getFecha()).toHours();

        if(diferenciaEnHoras < 24){
            throw new ValidationException("Consulta solamente puede ser cancelada presencialmente.");
        }
    }
}
