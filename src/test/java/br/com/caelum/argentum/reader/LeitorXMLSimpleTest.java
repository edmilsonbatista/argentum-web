package br.com.caelum.argentum.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;
import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLSimpleTest {

    @Test
    public void testLeitorXMLInstanciacao() {
        LeitorXML leitor = new LeitorXML();
        Assert.assertNotNull(leitor);
    }

    @Test
    public void testCarregaXMLVazio() {
        String xmlVazio = "<list></list>";
        LeitorXML leitor = new LeitorXML();
        InputStream xml = new ByteArrayInputStream(xmlVazio.getBytes());
        
        List<Negociacao> negocios = leitor.carrega(xml);
        Assert.assertNotNull(negocios);
        Assert.assertEquals(0, negocios.size());
    }
}