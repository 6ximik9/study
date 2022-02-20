namespace ZaminaText_Kursova_
{
    partial class ReplaceText
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnFileDialog = new System.Windows.Forms.Button();
            this.txtBoxFile = new System.Windows.Forms.TextBox();
            this.btnDeleteFile = new System.Windows.Forms.Button();
            this.txtBoxSearch = new System.Windows.Forms.TextBox();
            this.txtBoxReplace = new System.Windows.Forms.TextBox();
            this.Replace = new System.Windows.Forms.Button();
            this.lbl1 = new System.Windows.Forms.Label();
            this.lbl2 = new System.Windows.Forms.Label();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.файлToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.оПрограммеToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.закрытьПрограммуToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.оРазработчикеToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.lstBox1 = new System.Windows.Forms.ListBox();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.BtnOpnFileDir = new System.Windows.Forms.Button();
            this.btnMassReplace = new System.Windows.Forms.Button();
            this.zamena = new System.Windows.Forms.Button();
            this.zamenaDir = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnFileDialog
            // 
            this.btnFileDialog.Location = new System.Drawing.Point(28, 27);
            this.btnFileDialog.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnFileDialog.Name = "btnFileDialog";
            this.btnFileDialog.Size = new System.Drawing.Size(132, 46);
            this.btnFileDialog.TabIndex = 0;
            this.btnFileDialog.Text = "Відкрити файл";
            this.btnFileDialog.UseVisualStyleBackColor = true;
            this.btnFileDialog.Visible = false;
            this.btnFileDialog.Click += new System.EventHandler(this.btnFileDialog_Click);
            // 
            // txtBoxFile
            // 
            this.txtBoxFile.Location = new System.Drawing.Point(207, 32);
            this.txtBoxFile.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtBoxFile.Multiline = true;
            this.txtBoxFile.Name = "txtBoxFile";
            this.txtBoxFile.Size = new System.Drawing.Size(352, 29);
            this.txtBoxFile.TabIndex = 1;
            this.txtBoxFile.Visible = false;
            // 
            // btnDeleteFile
            // 
            this.btnDeleteFile.Font = new System.Drawing.Font("Microsoft Sans Serif", 6.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnDeleteFile.Location = new System.Drawing.Point(28, 81);
            this.btnDeleteFile.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnDeleteFile.Name = "btnDeleteFile";
            this.btnDeleteFile.Size = new System.Drawing.Size(132, 46);
            this.btnDeleteFile.TabIndex = 2;
            this.btnDeleteFile.Text = "Видалити файл";
            this.btnDeleteFile.UseVisualStyleBackColor = true;
            this.btnDeleteFile.Visible = false;
            this.btnDeleteFile.Click += new System.EventHandler(this.btnDeleteFile_Click);
            // 
            // txtBoxSearch
            // 
            this.txtBoxSearch.Location = new System.Drawing.Point(207, 108);
            this.txtBoxSearch.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtBoxSearch.Multiline = true;
            this.txtBoxSearch.Name = "txtBoxSearch";
            this.txtBoxSearch.Size = new System.Drawing.Size(173, 83);
            this.txtBoxSearch.TabIndex = 3;
            this.txtBoxSearch.Visible = false;
            // 
            // txtBoxReplace
            // 
            this.txtBoxReplace.Location = new System.Drawing.Point(389, 108);
            this.txtBoxReplace.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtBoxReplace.Multiline = true;
            this.txtBoxReplace.Name = "txtBoxReplace";
            this.txtBoxReplace.Size = new System.Drawing.Size(173, 83);
            this.txtBoxReplace.TabIndex = 4;
            this.txtBoxReplace.Visible = false;
            // 
            // Replace
            // 
            this.Replace.Location = new System.Drawing.Point(207, 199);
            this.Replace.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Replace.Name = "Replace";
            this.Replace.Size = new System.Drawing.Size(357, 46);
            this.Replace.TabIndex = 5;
            this.Replace.Text = "Замінити!";
            this.Replace.UseVisualStyleBackColor = true;
            this.Replace.Visible = false;
            this.Replace.Click += new System.EventHandler(this.Replace_Click);
            // 
            // lbl1
            // 
            this.lbl1.AutoSize = true;
            this.lbl1.Location = new System.Drawing.Point(207, 85);
            this.lbl1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(89, 17);
            this.lbl1.TabIndex = 6;
            this.lbl1.Text = "Що замінити";
            this.lbl1.Visible = false;
            this.lbl1.Click += new System.EventHandler(this.label1_Click);
            // 
            // lbl2
            // 
            this.lbl2.AutoSize = true;
            this.lbl2.Location = new System.Drawing.Point(389, 85);
            this.lbl2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lbl2.Name = "lbl2";
            this.lbl2.Size = new System.Drawing.Size(97, 17);
            this.lbl2.TabIndex = 7;
            this.lbl2.Text = "Чим замінити";
            this.lbl2.Visible = false;
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.файлToolStripMenuItem,
            this.оРазработчикеToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Padding = new System.Windows.Forms.Padding(8, 2, 0, 2);
            this.menuStrip1.Size = new System.Drawing.Size(587, 28);
            this.menuStrip1.TabIndex = 8;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // файлToolStripMenuItem
            // 
            this.файлToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.оПрограммеToolStripMenuItem,
            this.закрытьПрограммуToolStripMenuItem});
            this.файлToolStripMenuItem.Name = "файлToolStripMenuItem";
            this.файлToolStripMenuItem.Size = new System.Drawing.Size(57, 24);
            this.файлToolStripMenuItem.Text = "Файл";
            // 
            // оПрограммеToolStripMenuItem
            // 
            this.оПрограммеToolStripMenuItem.Name = "оПрограммеToolStripMenuItem";
            this.оПрограммеToolStripMenuItem.Size = new System.Drawing.Size(234, 26);
            this.оПрограммеToolStripMenuItem.Text = "Про курсовий проект";
            this.оПрограммеToolStripMenuItem.Click += new System.EventHandler(this.оПрограммеToolStripMenuItem_Click);
            // 
            // закрытьПрограммуToolStripMenuItem
            // 
            this.закрытьПрограммуToolStripMenuItem.Name = "закрытьПрограммуToolStripMenuItem";
            this.закрытьПрограммуToolStripMenuItem.Size = new System.Drawing.Size(234, 26);
            this.закрытьПрограммуToolStripMenuItem.Text = "Вихід";
            this.закрытьПрограммуToolStripMenuItem.Click += new System.EventHandler(this.закрытьПрограммуToolStripMenuItem_Click);
            // 
            // оРазработчикеToolStripMenuItem
            // 
            this.оРазработчикеToolStripMenuItem.Name = "оРазработчикеToolStripMenuItem";
            this.оРазработчикеToolStripMenuItem.Size = new System.Drawing.Size(139, 24);
            this.оРазработчикеToolStripMenuItem.Text = "Про розробника";
            this.оРазработчикеToolStripMenuItem.Click += new System.EventHandler(this.оРазработчикеToolStripMenuItem_Click);
            // 
            // lstBox1
            // 
            this.lstBox1.FormattingEnabled = true;
            this.lstBox1.ItemHeight = 16;
            this.lstBox1.Location = new System.Drawing.Point(16, 81);
            this.lstBox1.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.lstBox1.Name = "lstBox1";
            this.lstBox1.SelectionMode = System.Windows.Forms.SelectionMode.MultiSimple;
            this.lstBox1.Size = new System.Drawing.Size(159, 212);
            this.lstBox1.TabIndex = 9;
            this.lstBox1.Visible = false;
            // 
            // BtnOpnFileDir
            // 
            this.BtnOpnFileDir.Location = new System.Drawing.Point(16, 81);
            this.BtnOpnFileDir.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.BtnOpnFileDir.Name = "BtnOpnFileDir";
            this.BtnOpnFileDir.Size = new System.Drawing.Size(548, 44);
            this.BtnOpnFileDir.TabIndex = 10;
            this.BtnOpnFileDir.Text = "Відкрити Папку";
            this.BtnOpnFileDir.UseVisualStyleBackColor = true;
            this.BtnOpnFileDir.Visible = false;
            this.BtnOpnFileDir.Click += new System.EventHandler(this.button1_Click);
            // 
            // btnMassReplace
            // 
            this.btnMassReplace.Location = new System.Drawing.Point(207, 208);
            this.btnMassReplace.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnMassReplace.Name = "btnMassReplace";
            this.btnMassReplace.Size = new System.Drawing.Size(357, 55);
            this.btnMassReplace.TabIndex = 11;
            this.btnMassReplace.Text = "Замінити!";
            this.btnMassReplace.UseVisualStyleBackColor = true;
            this.btnMassReplace.Visible = false;
            this.btnMassReplace.Click += new System.EventHandler(this.button2_Click);
            // 
            // zamena
            // 
            this.zamena.Location = new System.Drawing.Point(207, 79);
            this.zamena.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.zamena.Name = "zamena";
            this.zamena.Size = new System.Drawing.Size(132, 81);
            this.zamena.TabIndex = 12;
            this.zamena.Text = "Замінити текст в одному файлі";
            this.zamena.UseVisualStyleBackColor = true;
            this.zamena.Click += new System.EventHandler(this.zamena_Click);
            // 
            // zamenaDir
            // 
            this.zamenaDir.Location = new System.Drawing.Point(389, 85);
            this.zamenaDir.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.zamenaDir.Name = "zamenaDir";
            this.zamenaDir.Size = new System.Drawing.Size(132, 81);
            this.zamenaDir.TabIndex = 13;
            this.zamenaDir.Text = "Замінити текст у декількох файлах";
            this.zamenaDir.UseVisualStyleBackColor = true;
            this.zamenaDir.Click += new System.EventHandler(this.zamenaDir_Click);
            // 
            // ReplaceText
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(587, 320);
            this.Controls.Add(this.zamenaDir);
            this.Controls.Add(this.zamena);
            this.Controls.Add(this.btnMassReplace);
            this.Controls.Add(this.BtnOpnFileDir);
            this.Controls.Add(this.lstBox1);
            this.Controls.Add(this.lbl2);
            this.Controls.Add(this.lbl1);
            this.Controls.Add(this.Replace);
            this.Controls.Add(this.txtBoxReplace);
            this.Controls.Add(this.txtBoxSearch);
            this.Controls.Add(this.btnDeleteFile);
            this.Controls.Add(this.txtBoxFile);
            this.Controls.Add(this.btnFileDialog);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "ReplaceText";
            this.Text = "Заміна тексту у файлах";
            this.Load += new System.EventHandler(this.ReplaceText_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnFileDialog;
        private System.Windows.Forms.TextBox txtBoxFile;
        private System.Windows.Forms.Button btnDeleteFile;
        private System.Windows.Forms.TextBox txtBoxSearch;
        private System.Windows.Forms.TextBox txtBoxReplace;
        private System.Windows.Forms.Button Replace;
        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Label lbl2;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem файлToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem оПрограммеToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem закрытьПрограммуToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem оРазработчикеToolStripMenuItem;
        private System.Windows.Forms.ListBox lstBox1;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.Button BtnOpnFileDir;
        private System.Windows.Forms.Button btnMassReplace;
        private System.Windows.Forms.Button zamena;
        private System.Windows.Forms.Button zamenaDir;
    }
}

