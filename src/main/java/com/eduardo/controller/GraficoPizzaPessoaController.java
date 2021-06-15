package com.eduardo.controller;

import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

import com.eduardo.repository.PessoaRepository;

@Named(value = "graficoPizzaPessoaController")
@RequestScoped
public class GraficoPizzaPessoaController {

	@Inject
	private PessoaRepository pessoaRepository;

	private PieChartModel pieChartModel;

	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}

	@PostConstruct
	public void init() {

		this.pieChartModel = new PieChartModel();

		this.MontaGrafico();
	}

	private void MontaGrafico() {

		Hashtable<String, Integer> hashtableRegistros = pessoaRepository.getSexoPessoa();

		hashtableRegistros.forEach((chave, valor) -> {
			pieChartModel.set(chave, valor);

		});

		pieChartModel.setTitle("Total de Pessoas cadastradas por Sexo");
		pieChartModel.setShowDataLabels(true);
		pieChartModel.setLegendPosition("e");
	}
}