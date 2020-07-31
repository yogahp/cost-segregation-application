package com.thesgg.cost.seg;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.thesgg.cost.seg");

        noClasses()
            .that()
            .resideInAnyPackage("com.thesgg.cost.seg.service..")
            .or()
            .resideInAnyPackage("com.thesgg.cost.seg.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.thesgg.cost.seg.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
