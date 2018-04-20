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

@Entity
@Table(name="NOTE_IDS")
public class NoteID {
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="BATCH_ID")
	@JsonBackReference
	private Batch noteBatch;
	
	@Id
	@Column(name="note_id")
	private int notesId;

	public NoteID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoteID(Batch noteBatch, int notesId) {
		super();
		this.noteBatch = noteBatch;
		this.notesId = notesId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noteBatch == null) ? 0 : noteBatch.hashCode());
		result = prime * result + notesId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoteID other = (NoteID) obj;
		if (noteBatch == null) {
			if (other.noteBatch != null)
				return false;
		} else if (!noteBatch.equals(other.noteBatch))
			return false;
		if (notesId != other.notesId)
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "NoteID [noteBatch=" + noteBatch + ", notesId=" + notesId + "]";
//	}

	public Batch getNoteBatch() {
		return noteBatch;
	}

	public void setNoteBatch(Batch noteBatch) {
		this.noteBatch = noteBatch;
	}

	public int getNotesId() {
		return notesId;
	}

	public void setNotesId(int notesId) {
		this.notesId = notesId;
	}

	


}
