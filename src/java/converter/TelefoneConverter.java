/*
 * Fonte: http://blog.algaworks.com/conversores-jsf/
 */
package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.Telefone;

@FacesConverter("telefoneConverter")
public class TelefoneConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        return "+" + ((Telefone) value).toString();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        String somenteNumeros = value.replaceAll("[^0-9]", "");//de +55 (11) 2626-9415 para 551126269415
        try {
            String codigoPais = somenteNumeros.substring(0, 2);
            String codigoArea = somenteNumeros.substring(2, 4);
            String numero = somenteNumeros.substring(4);

            return new Telefone(codigoPais, codigoArea, numero);
        } catch (IndexOutOfBoundsException e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Problemas na conversão do telefone.",
                    "Ele deve ser informado com código do país, de área e o número. Ex: +55 (11) 2626-9415");

            throw new ConverterException(facesMessage);
        }
    }
}
