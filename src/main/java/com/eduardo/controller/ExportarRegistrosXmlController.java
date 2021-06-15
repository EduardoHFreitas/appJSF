package com.eduardo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.eduardo.model.PessoaModel;
import com.eduardo.repository.PessoaRepository;
 
@Named(value="exportarRegistrosXmlController")
@RequestScoped
public class ExportarRegistrosXmlController implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	PessoaRepository pessoaRepository; 
 
	private StreamedContent arquivoDownload;
 
	/***
	 * REALIZA O DOWNLOAD DO ARQUIVO XML
	 * @return
	 */
	public StreamedContent getArquivoDownload() {
 
		this.downlaodArquivoXmlPessoa();
 
		return arquivoDownload;
	}
 
	private File gerarXmlPessoas(){
 
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
 
		List<PessoaModel> pessoasModel = pessoaRepository.getPessoas();
 
		Element elementPessoas = new Element("Pessoas");
 
		Document documentoPessoas = new Document(elementPessoas);
 
		pessoasModel.forEach(pessoa -> {
			Element elementPessoa = new Element("Pessoa");			
			elementPessoa.addContent(new Element("id").setText(pessoa.getId().toString()));
			elementPessoa.addContent(new Element("nome").setText(pessoa.getNome()));
			elementPessoa.addContent(new Element("sexo").setText(pessoa.getSexo()));
 
			String dataCadastroFormatada = pessoa.getDataCadastro().format(dateTimeFormatter);
 
			elementPessoa.addContent(new Element("dataCadastro").setText(dataCadastroFormatada));
			elementPessoa.addContent(new Element("email").setText(pessoa.getEmail()));
			elementPessoa.addContent(new Element("endereco").setText(pessoa.getEndereco()));
			elementPessoa.addContent(new Element("usuarioCadastro").setText(pessoa.getUsuarioModel().getLogin()));
 
			elementPessoas.addContent(elementPessoa);
		});
 
 
		XMLOutputter xmlGerado = new XMLOutputter();
 
		try {
			String nomeArquivo =  "pessoas_".concat(java.util.UUID.randomUUID().toString()).concat(".xml");
 
			File arquivo = new File("C:\\Users\\Eduardo\\Desktop\\".concat(nomeArquivo));
 
			FileWriter fileWriter =  new FileWriter(arquivo);
 
			xmlGerado.output(documentoPessoas, fileWriter);
 
			return arquivo;
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
 
		return null;
	}
 
	public void downlaodArquivoXmlPessoa(){
		File arquivoXml = this.gerarXmlPessoas();
 
		InputStream inputStream;
 
		try {
			inputStream = new FileInputStream(arquivoXml.getPath());
			arquivoDownload = new DefaultStreamedContent(inputStream,"application/xml",arquivoXml.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}