package com.revature.gambit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="NOTE_IDS")
public class NoteID {
	
	
	@ManyToOne
    @JoinColumn(name="BATCH_ID")
	private Batch batch;
	
	@Id
	@Column(name="note_id")
	private int notesId;

	public NoteID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoteID(int notesId) {
		super();
		this.notesId = notesId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (notesId != other.notesId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NoteID [notesId=" + notesId + "]";
	}

	public int getNotesId() {
		return notesId;
	}

	public void setNotesId(int notesId) {
		this.notesId = notesId;
	}


}
