package com.webdriver.datadriven;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import io.cucumber.docstring.DocStringType;

public class ExcelDataToDataTable implements TypeRegistry {

    @Override
    public void defineParameterType(ParameterType<?> parameterType) {

    }

    @Override
    public void defineDocStringType(DocStringType docStringType) {

    }

    @Override
    public void defineDataTableType(DataTableType dataTableType) {

    }

    @Override
    public void setDefaultParameterTransformer(ParameterByTypeTransformer parameterByTypeTransformer) {

    }

    @Override
    public void setDefaultDataTableEntryTransformer(TableEntryByTypeTransformer tableEntryByTypeTransformer) {

    }

    @Override
    public void setDefaultDataTableCellTransformer(TableCellByTypeTransformer tableCellByTypeTransformer) {

    }
}
