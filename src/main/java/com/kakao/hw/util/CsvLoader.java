package com.kakao.hw.util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvLoader {
	public static <T> List<T> loadCsvList(Class<T> type, MultipartFile mFile) {
		try {
			File file = new File(mFile.getOriginalFilename());
		    file.createNewFile();
			mFile.transferTo(file);
			
			CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
			CsvMapper mapper = new CsvMapper();
			MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(file);
			
			return readValues.readAll();
		} catch (IOException e) {
			log.error("upload fail", e);
			
	        return Collections.emptyList();
		}
		
	}

}
