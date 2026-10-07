package com.example.demo.entity;

import java.util.List;

public class DiagnosisForm {
	private List<Integer> selectedChoiceIds;
	
	public List<Integer> getSelectedChoiceIds() { return selectedChoiceIds; }
	public void setSelectedChoiceIds(List<Integer> selectedChoiceIds) {
		this.selectedChoiceIds = selectedChoiceIds;
	}
}
