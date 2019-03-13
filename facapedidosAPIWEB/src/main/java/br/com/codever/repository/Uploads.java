package br.com.codever.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.codever.model.Upload;

public interface Uploads extends JpaRepository <Upload,Long> {

}
