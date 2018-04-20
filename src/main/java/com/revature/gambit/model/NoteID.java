package com.revature.gambit.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="NOTE_IDS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NoteID {
	
	@Id
	@Column(name="NOTE_ID")
	private int notesId;

	@Column(name="BATCH_ID")
	private int batchId;

	public NoteID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoteID(int notesId, int batchId) {
		this.notesId = notesId;
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "NoteID{" +
				"notesId=" + notesId +
				", batchId=" + batchId +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		NoteID noteID = (NoteID) o;

		if (notesId != noteID.notesId) return false;
		return batchId == noteID.batchId;
	}

	@Override
	public int hashCode() {
		int result = notesId;
		result = 31 * result + batchId;
		return result;
	}

	public int getNotesId() {
		return notesId;
	}

	public void setNotesId(int notesId) {
		this.notesId = notesId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
}
