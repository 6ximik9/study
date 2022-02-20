using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ZaminaText_Kursova_
{
    public partial class ReplaceText : Form
    {
        string folder = "";
  
        



        public ReplaceText()
        {
            InitializeComponent();
        }


        private void btnFileDialog_Click(object sender, EventArgs e)
        {
            OpenFileDialog opnfldg = new OpenFileDialog();
            opnfldg.Filter = "txt |*.txt";

            if (opnfldg.ShowDialog() == DialogResult.OK)
            {
                txtBoxFile.Text = opnfldg.FileName;                
            }   
        }


        private void btnDeleteFile_Click(object sender, EventArgs e)
        {
            if (txtBoxFile.Text == "")
            {
                MessageBox.Show("Введите путь!");
            }
            else
            {
                File.Delete(txtBoxFile.Text);
                MessageBox.Show("Файл удалён!");
            }           
        }

        private void Replace_Click(object sender, EventArgs e)
        {
            string text = File.ReadAllText(txtBoxFile.Text, Encoding.UTF8);
            text = text.Replace(txtBoxSearch.Text, txtBoxReplace.Text);
            File.WriteAllText(txtBoxFile.Text, text);
            
            
            
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog fbd = new FolderBrowserDialog();
            if (fbd.ShowDialog() == DialogResult.OK)
            {
                var dir = new DirectoryInfo(fbd.SelectedPath);
                folder = dir.ToString();
                var files = dir.GetFiles("*.txt");
                lstBox1.Items.Clear();
                lstBox1.Items.AddRange(files);
                
            }
        }



        private void button2_Click(object sender, EventArgs e)
        {
            ListBox.SelectedIndexCollection indexes = lstBox1.SelectedIndices;
            foreach (int j in indexes)
            {
                string SpFile = lstBox1.Items[j].ToString();
                string FullPath = folder + @"\" + SpFile;

                string text = File.ReadAllText(FullPath, Encoding.UTF8);
                text = text.Replace(txtBoxSearch.Text, txtBoxReplace.Text);
                File.WriteAllText(FullPath, text);
            }
           
        }

        private void ReplaceText_Load(object sender, EventArgs e)
        {

        }

        private void zamena_Click(object sender, EventArgs e)
        {
            
            zamenaDir.Visible = false;
            btnFileDialog.Visible = true;
            zamena.Visible = false;
            btnDeleteFile.Visible = true;
            lbl1.Visible = true;
            lbl2.Visible = true;
            txtBoxSearch.Visible = true;
            txtBoxReplace.Visible = true;
            Replace.Visible = true;
            txtBoxFile.Visible = true;
            menuStrip1.Visible = true;
        }

        private void zamenaDir_Click(object sender, EventArgs e)
        {
            menuStrip1.Visible = true;
            lbl1.Visible = true;
            lbl2.Visible = true;
            txtBoxSearch.Visible = true;
            txtBoxReplace.Visible = true;
            zamenaDir.Visible = false;
            zamena.Visible = false;
            BtnOpnFileDir.Visible = true;
            lstBox1.Visible = true;
            btnMassReplace.Visible = true;
        }

        private void оРазработчикеToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Курсовий проєкт розробив студент групи КН-22 Корнієвський Андрій ", "Про розробника");
        }

        private void оПрограммеToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Курсовий проект розроблено для пошуку і заміни многострокових фрагментів тексту в файлах вказаного каталогу", "Про курсовий проект");
        }

        private void закрытьПрограммуToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
