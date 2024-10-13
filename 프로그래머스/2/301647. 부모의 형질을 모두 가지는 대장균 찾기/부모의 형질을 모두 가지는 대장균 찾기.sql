SELECT child.id, child.genotype genotype, parent.genotype parent_genotype
FROM ecoli_data child JOIN ecoli_data parent ON child.parent_id = parent.id
WHERE child.genotype & parent.genotype = parent.genotype
ORDER BY child.id;