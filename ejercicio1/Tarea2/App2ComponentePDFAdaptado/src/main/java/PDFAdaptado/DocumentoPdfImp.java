package PDFAdaptado;

import Interfaces.Documento;
import PDF.ComponentePDF;

public class DocumentoPdfImp implements Documento {
    ComponentePDF  herramientaPdf=new ComponentePDF();

    @Override
    public void setContenido(String contenido) {
        herramientaPdf.pdfFijaContenido(contenido);
    }
    @Override
    public void dibujar() {
        herramientaPdf.pdfPreparaVisualizacion();
        herramientaPdf.pdfRefresca();
        herramientaPdf.pdfFinalizarVisualizacion();
    }
    @Override
    public void imprimir() {
        herramientaPdf.pdfEnviarImpresora();
    }

}
