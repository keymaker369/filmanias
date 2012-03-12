package org.seke.filmanias.filmanias.utils;

import org.seke.filmanias.filmanias.domain.Genre;
import org.seke.filmanias.filmanias.domain.GenreBean;

public class GenreUtils {
	
	/**
	 * Creates new {@link GenreBean} object from {@link Genre} object.
	 * 
	 * @param genre
	 * @return
	 */
	public static GenreBean createGenreBeanFromGenre(Genre genre) {
		GenreBean genreBean = GenreBean.genreBean(genre, false, genre.getName());
		return genreBean;
	}
	
	/**
	 * Creates new {@link Genre} object from {@link GenreBean} object.
	 * 
	 * @param genre
	 * @return
	 */
	public static Genre createGenreFromGenreBean(GenreBean genreBean) {
		Genre genre = new Genre(genreBean.getName());
		return genre;
	}
}
