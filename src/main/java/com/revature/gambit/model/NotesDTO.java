package com.revature.gambit.model;

import java.util.Set;

/**
 * @author chris
 * Used for adding Trainees to batches received from messages
 */
public class NotesDTO {

	private int noteId;
	
	private Set<Integer> batches;
	
	public NotesDTO() {
		super();
	}


	public NotesDTO(int userId, Set<Integer> batches) {
		super();
		this.noteId = userId;
		this.batches = batches;
	}


	public int getNoteId() {
		return noteId;
	}


	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}


	public Set<Integer> getBatches() {
		return batches;
	}


	public void setBatches(Set<Integer> batches) {
		this.batches = batches;
	}
	
	
	
}
