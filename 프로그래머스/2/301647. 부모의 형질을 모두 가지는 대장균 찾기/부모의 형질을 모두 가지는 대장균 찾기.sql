SELECT a.id id, a.genotype genotype, b.genotype parent_genotype
FROM ecoli_data a JOIN ecoli_data b ON a.parent_id = b.id
WHERE a.genotype & b.genotype = b.genotype
ORDER BY id;