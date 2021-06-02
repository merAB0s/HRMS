package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.LanguageLevel;

import java.util.List;

public interface LanguageLevelService {

    DataResult<List<LanguageLevel>> getAll();

    Result add(LanguageLevel languageLevel);}
